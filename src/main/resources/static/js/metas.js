const dataInicialInput = document.getElementById('dataInicial');
const dataFinalInput = document.getElementById('dataFinal');
const periodoFiltro = document.getElementById('periodoFiltro');
const tipoVendedorFiltro = document.getElementById('tipoVendedorFiltro');
const statusBar = document.getElementById('statusBar');
const statusMessage = document.getElementById('statusMessage');
const reportTableBody = document.getElementById('reportTableBody');
const sellerTableBody = document.getElementById('sellerTableBody');
const reportCount = document.getElementById('reportCount');
const sellerCount = document.getElementById('sellerCount');
const ultimaAtualizacaoLabel = document.getElementById('ultimaAtualizacaoLabel');
const totalInstalacoes = document.getElementById('totalInstalacoes');
const totalVendedores = document.getElementById('totalVendedores');
const ticketMedio = document.getElementById('ticketMedio');
const pontosTotais = document.getElementById('pontosTotais');

const buscarDadosButton = document.getElementById('buscarDadosButton');
const exportarPlanilhaButton = document.getElementById('exportarPlanilhaButton');
const limparTabelasButton = document.getElementById('limparTabelasButton');
const dataMinimaPermitida = '2026-01-01';

//IA: Mantem os dados carregados em memoria para filtrar a planilha sem nova chamada ao backend.
let relatorioAtual = [];
let pontuacoesAtuais = [];
let vendedorSelecionado = null;

buscarDadosButton.addEventListener('click', buscarDados);
exportarPlanilhaButton.addEventListener('click', exportarPlanilha);
limparTabelasButton.addEventListener('click', limparTabelas);
periodoFiltro.addEventListener('change', aplicarPeriodoSelecionado);
dataInicialInput.addEventListener('change', marcarPeriodoPersonalizado);
dataFinalInput.addEventListener('change', marcarPeriodoPersonalizado);
tipoVendedorFiltro.addEventListener('change', resetarSelecaoVendedor);

preencherDatasPadrao();
buscarUltimaAtualizacaoCache();

function preencherDatasPadrao() {
    aplicarPeriodoSelecionado();
}

function aplicarPeriodoSelecionado() {
    const periodo = calcularPeriodo(periodoFiltro.value);

    if (!periodo) {
        return;
    }

    resetarSelecaoVendedor();
    dataInicialInput.value = limitarDataMinima(formatDateInput(periodo.dataInicial));
    dataFinalInput.value = limitarDataMinima(formatDateInput(periodo.dataFinal));
}

function marcarPeriodoPersonalizado() {
    resetarSelecaoVendedor();
    periodoFiltro.value = 'personalizado';
}

function calcularPeriodo(periodo) {
    const hoje = criarDataLocal();
    const ontem = new Date(hoje.getFullYear(), hoje.getMonth(), hoje.getDate() - 1);

    //IA: Centraliza os atalhos para manter data inicial/final previsiveis na tela e nas chamadas.
    const periodos = {
        'hoje': {
            dataInicial: hoje,
            dataFinal: hoje
        },
        'ontem': {
            dataInicial: ontem,
            dataFinal: ontem
        },
        'mes-atual': {
            dataInicial: new Date(hoje.getFullYear(), hoje.getMonth(), 1),
            dataFinal: hoje
        },
        'mes-passado': {
            dataInicial: new Date(hoje.getFullYear(), hoje.getMonth() - 1, 1),
            dataFinal: new Date(hoje.getFullYear(), hoje.getMonth(), 0)
        },
        'ultimos-3-meses': {
            dataInicial: new Date(hoje.getFullYear(), hoje.getMonth() - 3, hoje.getDate()),
            dataFinal: hoje
        },
        'ano-atual': {
            dataInicial: new Date(hoje.getFullYear(), 0, 1),
            dataFinal: hoje
        }
    };

    return periodos[periodo] || null;
}

function criarDataLocal() {
    return new Date();
}

function formatDateInput(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');

    return `${year}-${month}-${day}`;
}

function limitarDataMinima(value) {
    return value < dataMinimaPermitida
        ? dataMinimaPermitida
        : value;
}

function validarDatas() {
    const dataInicial = dataInicialInput.value;
    const dataFinal = dataFinalInput.value;

    if (!dataInicial || !dataFinal) {
        mostrarStatus('Informe a data inicial e final.', 'error');
        return false;
    }

    if (dataInicial > dataFinal) {
        mostrarStatus('A data inicial nao pode ser maior que a data final.', 'error');
        return false;
    }

    if (dataInicial < dataMinimaPermitida || dataFinal < dataMinimaPermitida) {
        mostrarStatus('Informe um periodo a partir de 01/01/2026.', 'error');
        return false;
    }

    return true;
}

async function buscarDados() {
    if (!validarDatas()) {
        return;
    }

    resetarSelecaoVendedor();

    const dataInicial = dataInicialInput.value;
    const dataFinal = dataFinalInput.value;

    mostrarStatus('Consultando cache local...', 'loading');
    setLoadingButtons(true, 'buscar');

    try {
        const query = montarQueryFiltros(dataInicial, dataFinal);
        const dashboardResponse = await fetch(`/metas/dashboard?${query}`);

        if (!dashboardResponse.ok) {
            throw new Error('Falha ao buscar dados do dashboard.');
        }

        const dashboard = await dashboardResponse.json();

        preencherDashboard(dashboard);
        mostrarStatus('Dados carregados com sucesso.', 'success');
    } catch (error) {
        console.error(error);
        mostrarStatus(error.message || 'Erro inesperado ao carregar os dados.', 'error');
    } finally {
        setLoadingButtons(false);
    }
}

function preencherDashboard(dashboard) {
    relatorioAtual = dashboard.relatorio || [];
    pontuacoesAtuais = dashboard.pontuacoes || [];

    aplicarFiltroVendedorSelecionado();
    preencherTabelaVendedores(pontuacoesAtuais);
    atualizarUltimaAtualizacao(dashboard.ultimaAtualizacao);
}

function aplicarFiltroVendedorSelecionado() {
    //IA: A selecao no ranking tambem recalcula os indicadores superiores.
    const relatorioFiltrado = vendedorSelecionado
        ? relatorioAtual.filter(item => item.nomeVendedor === vendedorSelecionado)
        : relatorioAtual;
    const pontuacoesFiltradas = vendedorSelecionado
        ? pontuacoesAtuais.filter(item => item.nomeVendedor === vendedorSelecionado)
        : pontuacoesAtuais;

    preencherTabelaRelatorio(relatorioFiltrado);
    atualizarResumo(relatorioFiltrado, pontuacoesFiltradas);
}

function preencherTabelaRelatorio(dados) {
    reportTableBody.innerHTML = '';
    reportCount.textContent = `${dados.length} registro${dados.length === 1 ? '' : 's'}`;

    if (!dados.length) {
        reportTableBody.innerHTML = `
            <tr>
                <td colspan="6" class="empty">Nenhum dado encontrado no cache para o periodo.</td>
            </tr>
        `;
        return;
    }

    dados.forEach(item => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${formatarData(item.dataInstalacao)}</td>
            <td>${item.idContrato ?? '-'}</td>
            <td>${item.nomeCliente ?? '-'}</td>
            <td>${item.nomePlano ?? '-'}</td>
            <td>${item.nomeVendedor ?? '-'}</td>
            <td class="money">${formatarMoeda(item.ticket)}</td>
        `;

        reportTableBody.appendChild(row);
    });
}

function preencherTabelaVendedores(dados) {
    sellerTableBody.innerHTML = '';
    sellerCount.textContent = `${dados.length} vendedor${dados.length === 1 ? '' : 'es'}`;

    if (!dados.length) {
        sellerTableBody.innerHTML = `
            <tr>
                <td colspan="3" class="empty">Nenhuma pontuacao encontrada para o periodo.</td>
            </tr>
        `;
        return;
    }

    dados.forEach((item, index) => {
        const row = document.createElement('tr');
        const isSelecionado = item.nomeVendedor === vendedorSelecionado;

        row.innerHTML = `
            <td>${index + 1}</td>
            <td></td>
            <td class="points">${formatarNumero(item.pontosTotais)}</td>
        `;

        const sellerButton = document.createElement('button');
        sellerButton.className = `seller-filter-button${isSelecionado ? ' selected' : ''}`;
        sellerButton.type = 'button';
        sellerButton.textContent = item.nomeVendedor ?? '-';

        //IA: O clique troca a selecao para um unico vendedor e refiltra somente a planilha.
        sellerButton.addEventListener('click', () => {
            selecionarVendedor(item.nomeVendedor);
        });

        row.children[1].appendChild(sellerButton);
        sellerTableBody.appendChild(row);
    });
}

function selecionarVendedor(nomeVendedor) {
    if (!nomeVendedor) {
        return;
    }

    //IA: Re-clicar no vendedor selecionado remove o recorte e volta a mostrar todos.
    vendedorSelecionado = vendedorSelecionado === nomeVendedor
        ? null
        : nomeVendedor;

    aplicarFiltroVendedorSelecionado();
    preencherTabelaVendedores(pontuacoesAtuais);
}

function resetarSelecaoVendedor() {
    //IA: Qualquer mudanca nos filtros principais remove o recorte local por vendedor.
    vendedorSelecionado = null;

    if (relatorioAtual.length || pontuacoesAtuais.length) {
        aplicarFiltroVendedorSelecionado();
        preencherTabelaVendedores(pontuacoesAtuais);
    }
}

function exportarPlanilha() {
    if (!validarDatas()) {
        return;
    }

    const dataInicial = dataInicialInput.value;
    const dataFinal = dataFinalInput.value;
    const url = `/metas/relatorio?${montarQueryFiltros(dataInicial, dataFinal)}`;

    window.location.href = url;
}

function montarQueryFiltros(dataInicial, dataFinal) {
    const params = new URLSearchParams({
        dataInicial,
        dataFinal
    });

    //IA: Envia o tipo somente quando o usuario escolher interno ou externo.
    if (tipoVendedorFiltro.value) {
        params.append('tipoVendedor', tipoVendedorFiltro.value);
    }

    return params.toString();
}

function limparTabelas() {
    relatorioAtual = [];
    pontuacoesAtuais = [];
    resetarSelecaoVendedor();

    reportTableBody.innerHTML = `
        <tr>
            <td colspan="6" class="empty">Selecione um periodo e clique em buscar.</td>
        </tr>
    `;

    sellerTableBody.innerHTML = `
        <tr>
            <td colspan="3" class="empty">Nenhuma pontuacao carregada.</td>
        </tr>
    `;

    reportCount.textContent = '0 registros';
    sellerCount.textContent = '0 vendedores';
    atualizarUltimaAtualizacao(null);
    atualizarResumo([], []);
    esconderStatus();
}

function atualizarUltimaAtualizacao(value) {
    ultimaAtualizacaoLabel.textContent = `Ultima atualizacao: ${formatarDataHora(value)}`;
}

async function buscarUltimaAtualizacaoCache() {
    try {
        //IA: Alimenta o indicador inicial sem carregar dados do relatorio.
        const response = await fetch('/metas/cache/ultima-atualizacao');

        if (!response.ok) {
            throw new Error('Falha ao buscar ultima atualizacao do cache.');
        }

        const ultimaAtualizacao = await response.json();

        atualizarUltimaAtualizacao(ultimaAtualizacao);
    } catch (error) {
        console.error(error);
        atualizarUltimaAtualizacao(null);
    }
}

function atualizarResumo(relatorio, pontuacoes) {
    const totalTicket = relatorio.reduce((total, item) => {
        return total + Number(item.ticket || 0);
    }, 0);
    const ticketMedioValor = relatorio.length
        ? totalTicket / relatorio.length
        : 0;

    const totalPontos = pontuacoes.reduce((total, item) => {
        return total + Number(item.pontosTotais || 0);
    }, 0);

    totalInstalacoes.textContent = relatorio.length.toString();
    totalVendedores.textContent = pontuacoes.length.toString();
    ticketMedio.textContent = formatarMoeda(ticketMedioValor);
    pontosTotais.textContent = formatarNumero(totalPontos);
}

function mostrarStatus(message, type) {
    statusBar.style.display = 'block';
    statusMessage.className = `status ${type}`;

    if (type === 'loading') {
        statusMessage.innerHTML = `<span class="spinner"></span>${message}`;
    } else {
        statusMessage.textContent = message;
    }
}

function esconderStatus() {
    statusBar.style.display = 'none';
    statusMessage.textContent = '';
    statusMessage.className = 'status';
}

function setLoadingButtons(isLoading, source) {
    buscarDadosButton.disabled = isLoading;
    exportarPlanilhaButton.disabled = isLoading;
    limparTabelasButton.disabled = isLoading;

    buscarDadosButton.textContent = isLoading && source === 'buscar'
        ? 'Buscando...'
        : 'Buscar dados';
}

function formatarData(value) {
    if (!value) {
        return '-';
    }

    const partes = value.split('-');

    if (partes.length !== 3) {
        return value;
    }

    return `${partes[2]}/${partes[1]}/${partes[0]}`;
}

function formatarMoeda(value) {
    const number = Number(value || 0);

    return number.toLocaleString('pt-BR', {
        style: 'currency',
        currency: 'BRL'
    });
}

function formatarNumero(value) {
    const number = Number(value || 0);

    return number.toLocaleString('pt-BR', {
        minimumFractionDigits: 0,
        maximumFractionDigits: 2
    });
}

function formatarDataHora(value) {
    if (!value) {
        return '-';
    }

    const date = new Date(value);

    if (Number.isNaN(date.getTime())) {
        return value;
    }

    return date.toLocaleString('pt-BR', {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric',
        hour: '2-digit',
        minute: '2-digit'
    });
}
