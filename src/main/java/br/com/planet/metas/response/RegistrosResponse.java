package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrosResponse {

    @JsonProperty("mensagem_resposta")
    private String mensagemResposta;

    @JsonProperty("data_hora_analise")
    private String dataHoraAnalise;

    @JsonProperty("data_hora_encaminhado")
    private String dataHoraEncaminhado;

    @JsonProperty("data_hora_assumido")
    private String dataHoraAssumido;

    @JsonProperty("data_hora_execucao")
    private String dataHoraExecucao;

    @JsonProperty("id_contrato_kit")
    private String idContratoKit;

    private String preview;

    @JsonProperty("data_agenda_final")
    private String dataAgendaFinal;

    private String id;
    private String tipo;

    @JsonProperty("id_filial")
    private String idFilial;

    @JsonProperty("id_wfl_tarefa")
    private String idWflTarefa;

    @JsonProperty("status_sla")
    private String statusSla;

    @JsonProperty("data_abertura")
    private String dataAbertura;

    @JsonProperty("melhor_horario_agenda")
    private String melhorHorarioAgenda;

    private String liberado;
    private String status;

    @JsonProperty("id_cliente")
    private String idCliente;

    @JsonProperty("id_assunto")
    private String idAssunto;

    private String setor;

    @JsonProperty("id_cidade")
    private String idCidade;

    @JsonProperty("id_tecnico")
    private String idTecnico;

    private String prioridade;

    @JsonProperty("origem_os_aberta")
    private String origemOsAberta;

    private String mensagem;
    private String protocolo;
    private String endereco;
    private String complemento;

    @JsonProperty("id_condominio")
    private String idCondominio;

    private String bloco;
    private String latitude;
    private String apartamento;
    private String longitude;
    private String bairro;
    private String referencia;
    private String impresso;

    @JsonProperty("data_inicio")
    private String dataInicio;

    @JsonProperty("data_agenda")
    private String dataAgenda;

    @JsonProperty("data_final")
    private String dataFinal;

    @JsonProperty("data_fechamento")
    private String dataFechamento;

    @JsonProperty("id_wfl_param_os")
    private String idWflParamOs;

    @JsonProperty("valor_outras_despesas")
    private String valorOutrasDespesas;

    @JsonProperty("valor_total_comissao")
    private String valorTotalComissao;

    @JsonProperty("valor_total")
    private String valorTotal;

    private String idx;

    @JsonProperty("gera_comissao")
    private String geraComissao;

    @JsonProperty("id_su_diagnostico")
    private String idSuDiagnostico;

    @JsonProperty("valor_unit_comissao")
    private String valorUnitComissao;

    @JsonProperty("id_estrutura")
    private String idEstrutura;

    @JsonProperty("id_login")
    private String idLogin;

    @JsonProperty("data_prazo_limite")
    private String dataPrazoLimite;

    @JsonProperty("data_reservada")
    private String dataReservada;

    @JsonProperty("id_ticket")
    private String idTicket;

    @JsonProperty("origem_endereco")
    private String origemEndereco;

    @JsonProperty("justificativa_sla_atrasado")
    private String justificativaSlaAtrasado;

    @JsonProperty("origem_endereco_estrutura")
    private String origemEnderecoEstrutura;

    @JsonProperty("data_reagendar")
    private String dataReagendar;

    @JsonProperty("data_prev_final")
    private String dataPrevFinal;

    @JsonProperty("origem_cadastro")
    private String origemCadastro;

    @JsonProperty("ultima_atualizacao")
    private String ultimaAtualizacao;

    public String getMensagemResposta() {
        return mensagemResposta;
    }

    public void setMensagemResposta(String mensagemResposta) {
        this.mensagemResposta = mensagemResposta;
    }

    public String getDataHoraAnalise() {
        return dataHoraAnalise;
    }

    public void setDataHoraAnalise(String dataHoraAnalise) {
        this.dataHoraAnalise = dataHoraAnalise;
    }

    public String getDataHoraEncaminhado() {
        return dataHoraEncaminhado;
    }

    public void setDataHoraEncaminhado(String dataHoraEncaminhado) {
        this.dataHoraEncaminhado = dataHoraEncaminhado;
    }

    public String getDataHoraAssumido() {
        return dataHoraAssumido;
    }

    public void setDataHoraAssumido(String dataHoraAssumido) {
        this.dataHoraAssumido = dataHoraAssumido;
    }

    public String getDataHoraExecucao() {
        return dataHoraExecucao;
    }

    public void setDataHoraExecucao(String dataHoraExecucao) {
        this.dataHoraExecucao = dataHoraExecucao;
    }

    public String getIdContratoKit() {
        return idContratoKit;
    }

    public void setIdContratoKit(String idContratoKit) {
        this.idContratoKit = idContratoKit;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDataAgendaFinal() {
        return dataAgendaFinal;
    }

    public void setDataAgendaFinal(String dataAgendaFinal) {
        this.dataAgendaFinal = dataAgendaFinal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(String idFilial) {
        this.idFilial = idFilial;
    }

    public String getIdWflTarefa() {
        return idWflTarefa;
    }

    public void setIdWflTarefa(String idWflTarefa) {
        this.idWflTarefa = idWflTarefa;
    }

    public String getStatusSla() {
        return statusSla;
    }

    public void setStatusSla(String statusSla) {
        this.statusSla = statusSla;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getMelhorHorarioAgenda() {
        return melhorHorarioAgenda;
    }

    public void setMelhorHorarioAgenda(String melhorHorarioAgenda) {
        this.melhorHorarioAgenda = melhorHorarioAgenda;
    }

    public String getLiberado() {
        return liberado;
    }

    public void setLiberado(String liberado) {
        this.liberado = liberado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(String idAssunto) {
        this.idAssunto = idAssunto;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getOrigemOsAberta() {
        return origemOsAberta;
    }

    public void setOrigemOsAberta(String origemOsAberta) {
        this.origemOsAberta = origemOsAberta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getImpresso() {
        return impresso;
    }

    public void setImpresso(String impresso) {
        this.impresso = impresso;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(String dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getIdWflParamOs() {
        return idWflParamOs;
    }

    public void setIdWflParamOs(String idWflParamOs) {
        this.idWflParamOs = idWflParamOs;
    }

    public String getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(String valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public String getValorTotalComissao() {
        return valorTotalComissao;
    }

    public void setValorTotalComissao(String valorTotalComissao) {
        this.valorTotalComissao = valorTotalComissao;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getGeraComissao() {
        return geraComissao;
    }

    public void setGeraComissao(String geraComissao) {
        this.geraComissao = geraComissao;
    }

    public String getIdSuDiagnostico() {
        return idSuDiagnostico;
    }

    public void setIdSuDiagnostico(String idSuDiagnostico) {
        this.idSuDiagnostico = idSuDiagnostico;
    }

    public String getValorUnitComissao() {
        return valorUnitComissao;
    }

    public void setValorUnitComissao(String valorUnitComissao) {
        this.valorUnitComissao = valorUnitComissao;
    }

    public String getIdEstrutura() {
        return idEstrutura;
    }

    public void setIdEstrutura(String idEstrutura) {
        this.idEstrutura = idEstrutura;
    }

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getDataPrazoLimite() {
        return dataPrazoLimite;
    }

    public void setDataPrazoLimite(String dataPrazoLimite) {
        this.dataPrazoLimite = dataPrazoLimite;
    }

    public String getDataReservada() {
        return dataReservada;
    }

    public void setDataReservada(String dataReservada) {
        this.dataReservada = dataReservada;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getOrigemEndereco() {
        return origemEndereco;
    }

    public void setOrigemEndereco(String origemEndereco) {
        this.origemEndereco = origemEndereco;
    }

    public String getJustificativaSlaAtrasado() {
        return justificativaSlaAtrasado;
    }

    public void setJustificativaSlaAtrasado(String justificativaSlaAtrasado) {
        this.justificativaSlaAtrasado = justificativaSlaAtrasado;
    }

    public String getOrigemEnderecoEstrutura() {
        return origemEnderecoEstrutura;
    }

    public void setOrigemEnderecoEstrutura(String origemEnderecoEstrutura) {
        this.origemEnderecoEstrutura = origemEnderecoEstrutura;
    }

    public String getDataReagendar() {
        return dataReagendar;
    }

    public void setDataReagendar(String dataReagendar) {
        this.dataReagendar = dataReagendar;
    }

    public String getDataPrevFinal() {
        return dataPrevFinal;
    }

    public void setDataPrevFinal(String dataPrevFinal) {
        this.dataPrevFinal = dataPrevFinal;
    }

    public String getOrigemCadastro() {
        return origemCadastro;
    }

    public void setOrigemCadastro(String origemCadastro) {
        this.origemCadastro = origemCadastro;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }


    
}
