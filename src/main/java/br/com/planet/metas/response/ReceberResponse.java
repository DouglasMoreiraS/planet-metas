package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceberResponse {

    @JsonProperty("page")
    private String page;

    @JsonProperty("total")
    private String total;

    @JsonProperty("registros")
    private List<Registro> registros;

    // Getters e setters

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Registro {

        @JsonProperty("id_remessa")
        private String idRemessa;

        @JsonProperty("gateway_link")
        private String gatewayLink;

        @JsonProperty("nn_boleto")
        private String nnBoleto;

        @JsonProperty("boleto")
        private String boleto;

        @JsonProperty("data_inicial")
        private String dataInicial;

        @JsonProperty("data_final")
        private String dataFinal;

        @JsonProperty("estornado")
        private String estornado;

        @JsonProperty("id")
        private String id;

        @JsonProperty("liberado")
        private String liberado;

        @JsonProperty("filial_id")
        private String filialId;

        @JsonProperty("status")
        private String status;

        @JsonProperty("data_emissao")
        private String dataEmissao;

        @JsonProperty("data_vencimento")
        private String dataVencimento;

        @JsonProperty("valor")
        private String valor;

        @JsonProperty("obs")
        private String obs;

        @JsonProperty("valor_recebido")
        private String valorRecebido;

        @JsonProperty("valor_aberto")
        private String valorAberto;

        @JsonProperty("id_cliente")
        private String idCliente;

        @JsonProperty("pagamento_valor")
        private String pagamentoValor;

        @JsonProperty("pagamento_data")
        private String pagamentoData;

        @JsonProperty("id_carteira_cobranca")
        private String idCarteiraCobranca;

        @JsonProperty("credito_data")
        private String creditoData;

        @JsonProperty("baixa_data")
        private String baixaData;

        @JsonProperty("numero_parcela_recorrente")
        private String numeroParcelaRecorrente;

        @JsonProperty("documento")
        private String documento;

        @JsonProperty("id_saida")
        private String idSaida;

        @JsonProperty("tipo_recebimento")
        private String tipoRecebimento;

        @JsonProperty("tipo_renegociacao")
        private String tipoRenegociacao;

        @JsonProperty("valor_cancelado")
        private String valorCancelado;

        @JsonProperty("data_cancelamento")
        private String dataCancelamento;

        @JsonProperty("id_mot_cancelamento")
        private String idMotCancelamento;

        @JsonProperty("id_renegociacao")
        private String idRenegociacao;

        @JsonProperty("id_cobranca")
        private String idCobranca;

        @JsonProperty("previsao")
        private String previsao;

        @JsonProperty("id_renegociacao_novo")
        private String idRenegociacaoNovo;

        @JsonProperty("libera_periodo")
        private String liberaPeriodo;

        @JsonProperty("impresso")
        private String impresso;

        @JsonProperty("forma_recebimento")
        private String formaRecebimento;

        @JsonProperty("arquivo_remessa_baixado")
        private String arquivoRemessaBaixado;

        @JsonProperty("nparcela")
        private String nparcela;

        @JsonProperty("id_nota_gerada_opc4")
        private String idNotaGeradaOpc4;

        @JsonProperty("status_cobranca")
        private String statusCobranca;

        @JsonProperty("tipo_cobranca")
        private String tipoCobranca;

        @JsonProperty("id_contrato_principal")
        private String idContratoPrincipal;

        @JsonProperty("id_contrato_avulso")
        private String idContratoAvulso;

        @JsonProperty("id_contrato")
        private String idContrato;

        @JsonProperty("id_nota_gerada")
        private String idNotaGerada;

        @JsonProperty("id_im_imovel")
        private String idImImovel;

        @JsonProperty("parcela_proporcional")
        private String parcelaProporcional;

        @JsonProperty("linha_digitavel")
        private String linhaDigitavel;

        @JsonProperty("duplicata")
        private String duplicata;

        @JsonProperty("tipo_pagamento_cartao")
        private String tipoPagamentoCartao;

        @JsonProperty("id_sip")
        private String idSip;

        @JsonProperty("titulo_protestado")
        private String tituloProtestado;

        @JsonProperty("desconto_condicional_valor")
        private String descontoCondicionalValor;

        @JsonProperty("gerencianet_token")
        private String gerencianetToken;

        @JsonProperty("validade_desconto_condicional")
        private String validadeDescontoCondicional;

        @JsonProperty("id_conta")
        private String idConta;

        @JsonProperty("titulo_renegociado")
        private String tituloRenegociado;

        @JsonProperty("motivo_alteracao")
        private String motivoAlteracao;

        @JsonProperty("id_remessa_alteracao")
        private String idRemessaAlteracao;

        @JsonProperty("cancelamento_id_operador")
        private String cancelamentoIdOperador;

        @JsonProperty("baixa_id_operador")
        private String baixaIdOperador;

        @JsonProperty("titulo_importado")
        private String tituloImportado;

        @JsonProperty("origem_importacao")
        private String origemImportacao;

        @JsonProperty("ultima_atualizacao")
        private String ultimaAtualizacao;

        @JsonProperty("aguardando_confirmacao_pagamento")
        private String aguardandoConfirmacaoPagamento;

        @JsonProperty("parcelado_cartao")
        private String parceladoCartao;

        @JsonProperty("pix_txid")
        private String pixTxid;

        @JsonProperty("id_nota_gerada_opc2")
        private String idNotaGeradaOpc2;

        @JsonProperty("id_nota_gerada_opc3")
        private String idNotaGeradaOpc3;

        @JsonProperty("recebido_via_pix")
        private String recebidoViaPix;

        @JsonProperty("id_lote_geracao_financeiro_fatura")
        private String idLoteGeracaoFinanceiroFatura;

        public String getIdRemessa() {
            return idRemessa;
        }

        public void setIdRemessa(String idRemessa) {
            this.idRemessa = idRemessa;
        }

        public String getGatewayLink() {
            return gatewayLink;
        }

        public void setGatewayLink(String gatewayLink) {
            this.gatewayLink = gatewayLink;
        }

        public String getNnBoleto() {
            return nnBoleto;
        }

        public void setNnBoleto(String nnBoleto) {
            this.nnBoleto = nnBoleto;
        }

        public String getBoleto() {
            return boleto;
        }

        public void setBoleto(String boleto) {
            this.boleto = boleto;
        }

        public String getDataInicial() {
            return dataInicial;
        }

        public void setDataInicial(String dataInicial) {
            this.dataInicial = dataInicial;
        }

        public String getDataFinal() {
            return dataFinal;
        }

        public void setDataFinal(String dataFinal) {
            this.dataFinal = dataFinal;
        }

        public String getEstornado() {
            return estornado;
        }

        public void setEstornado(String estornado) {
            this.estornado = estornado;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLiberado() {
            return liberado;
        }

        public void setLiberado(String liberado) {
            this.liberado = liberado;
        }

        public String getFilialId() {
            return filialId;
        }

        public void setFilialId(String filialId) {
            this.filialId = filialId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDataEmissao() {
            return dataEmissao;
        }

        public void setDataEmissao(String dataEmissao) {
            this.dataEmissao = dataEmissao;
        }

        public String getDataVencimento() {
            return dataVencimento;
        }

        public void setDataVencimento(String dataVencimento) {
            this.dataVencimento = dataVencimento;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public String getObs() {
            return obs;
        }

        public void setObs(String obs) {
            this.obs = obs;
        }

        public String getValorRecebido() {
            return valorRecebido;
        }

        public void setValorRecebido(String valorRecebido) {
            this.valorRecebido = valorRecebido;
        }

        public String getValorAberto() {
            return valorAberto;
        }

        public void setValorAberto(String valorAberto) {
            this.valorAberto = valorAberto;
        }

        public String getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(String idCliente) {
            this.idCliente = idCliente;
        }

        public String getPagamentoValor() {
            return pagamentoValor;
        }

        public void setPagamentoValor(String pagamentoValor) {
            this.pagamentoValor = pagamentoValor;
        }

        public String getPagamentoData() {
            return pagamentoData;
        }

        public void setPagamentoData(String pagamentoData) {
            this.pagamentoData = pagamentoData;
        }

        public String getIdCarteiraCobranca() {
            return idCarteiraCobranca;
        }

        public void setIdCarteiraCobranca(String idCarteiraCobranca) {
            this.idCarteiraCobranca = idCarteiraCobranca;
        }

        public String getCreditoData() {
            return creditoData;
        }

        public void setCreditoData(String creditoData) {
            this.creditoData = creditoData;
        }

        public String getBaixaData() {
            return baixaData;
        }

        public void setBaixaData(String baixaData) {
            this.baixaData = baixaData;
        }

        public String getNumeroParcelaRecorrente() {
            return numeroParcelaRecorrente;
        }

        public void setNumeroParcelaRecorrente(String numeroParcelaRecorrente) {
            this.numeroParcelaRecorrente = numeroParcelaRecorrente;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getIdSaida() {
            return idSaida;
        }

        public void setIdSaida(String idSaida) {
            this.idSaida = idSaida;
        }

        public String getTipoRecebimento() {
            return tipoRecebimento;
        }

        public void setTipoRecebimento(String tipoRecebimento) {
            this.tipoRecebimento = tipoRecebimento;
        }

        public String getTipoRenegociacao() {
            return tipoRenegociacao;
        }

        public void setTipoRenegociacao(String tipoRenegociacao) {
            this.tipoRenegociacao = tipoRenegociacao;
        }

        public String getValorCancelado() {
            return valorCancelado;
        }

        public void setValorCancelado(String valorCancelado) {
            this.valorCancelado = valorCancelado;
        }

        public String getDataCancelamento() {
            return dataCancelamento;
        }

        public void setDataCancelamento(String dataCancelamento) {
            this.dataCancelamento = dataCancelamento;
        }

        public String getIdMotCancelamento() {
            return idMotCancelamento;
        }

        public void setIdMotCancelamento(String idMotCancelamento) {
            this.idMotCancelamento = idMotCancelamento;
        }

        public String getIdRenegociacao() {
            return idRenegociacao;
        }

        public void setIdRenegociacao(String idRenegociacao) {
            this.idRenegociacao = idRenegociacao;
        }

        public String getIdCobranca() {
            return idCobranca;
        }

        public void setIdCobranca(String idCobranca) {
            this.idCobranca = idCobranca;
        }

        public String getPrevisao() {
            return previsao;
        }

        public void setPrevisao(String previsao) {
            this.previsao = previsao;
        }

        public String getIdRenegociacaoNovo() {
            return idRenegociacaoNovo;
        }

        public void setIdRenegociacaoNovo(String idRenegociacaoNovo) {
            this.idRenegociacaoNovo = idRenegociacaoNovo;
        }

        public String getLiberaPeriodo() {
            return liberaPeriodo;
        }

        public void setLiberaPeriodo(String liberaPeriodo) {
            this.liberaPeriodo = liberaPeriodo;
        }

        public String getImpresso() {
            return impresso;
        }

        public void setImpresso(String impresso) {
            this.impresso = impresso;
        }

        public String getFormaRecebimento() {
            return formaRecebimento;
        }

        public void setFormaRecebimento(String formaRecebimento) {
            this.formaRecebimento = formaRecebimento;
        }

        public String getArquivoRemessaBaixado() {
            return arquivoRemessaBaixado;
        }

        public void setArquivoRemessaBaixado(String arquivoRemessaBaixado) {
            this.arquivoRemessaBaixado = arquivoRemessaBaixado;
        }

        public String getNparcela() {
            return nparcela;
        }

        public void setNparcela(String nparcela) {
            this.nparcela = nparcela;
        }

        public String getIdNotaGeradaOpc4() {
            return idNotaGeradaOpc4;
        }

        public void setIdNotaGeradaOpc4(String idNotaGeradaOpc4) {
            this.idNotaGeradaOpc4 = idNotaGeradaOpc4;
        }

        public String getStatusCobranca() {
            return statusCobranca;
        }

        public void setStatusCobranca(String statusCobranca) {
            this.statusCobranca = statusCobranca;
        }

        public String getTipoCobranca() {
            return tipoCobranca;
        }

        public void setTipoCobranca(String tipoCobranca) {
            this.tipoCobranca = tipoCobranca;
        }

        public String getIdContratoPrincipal() {
            return idContratoPrincipal;
        }

        public void setIdContratoPrincipal(String idContratoPrincipal) {
            this.idContratoPrincipal = idContratoPrincipal;
        }

        public String getIdContratoAvulso() {
            return idContratoAvulso;
        }

        public void setIdContratoAvulso(String idContratoAvulso) {
            this.idContratoAvulso = idContratoAvulso;
        }

        public String getIdContrato() {
            return idContrato;
        }

        public void setIdContrato(String idContrato) {
            this.idContrato = idContrato;
        }

        public String getIdNotaGerada() {
            return idNotaGerada;
        }

        public void setIdNotaGerada(String idNotaGerada) {
            this.idNotaGerada = idNotaGerada;
        }

        public String getIdImImovel() {
            return idImImovel;
        }

        public void setIdImImovel(String idImImovel) {
            this.idImImovel = idImImovel;
        }

        public String getParcelaProporcional() {
            return parcelaProporcional;
        }

        public void setParcelaProporcional(String parcelaProporcional) {
            this.parcelaProporcional = parcelaProporcional;
        }

        public String getLinhaDigitavel() {
            return linhaDigitavel;
        }

        public void setLinhaDigitavel(String linhaDigitavel) {
            this.linhaDigitavel = linhaDigitavel;
        }

        public String getDuplicata() {
            return duplicata;
        }

        public void setDuplicata(String duplicata) {
            this.duplicata = duplicata;
        }

        public String getTipoPagamentoCartao() {
            return tipoPagamentoCartao;
        }

        public void setTipoPagamentoCartao(String tipoPagamentoCartao) {
            this.tipoPagamentoCartao = tipoPagamentoCartao;
        }

        public String getIdSip() {
            return idSip;
        }

        public void setIdSip(String idSip) {
            this.idSip = idSip;
        }

        public String getTituloProtestado() {
            return tituloProtestado;
        }

        public void setTituloProtestado(String tituloProtestado) {
            this.tituloProtestado = tituloProtestado;
        }

        public String getDescontoCondicionalValor() {
            return descontoCondicionalValor;
        }

        public void setDescontoCondicionalValor(String descontoCondicionalValor) {
            this.descontoCondicionalValor = descontoCondicionalValor;
        }

        public String getGerencianetToken() {
            return gerencianetToken;
        }

        public void setGerencianetToken(String gerencianetToken) {
            this.gerencianetToken = gerencianetToken;
        }

        public String getValidadeDescontoCondicional() {
            return validadeDescontoCondicional;
        }

        public void setValidadeDescontoCondicional(String validadeDescontoCondicional) {
            this.validadeDescontoCondicional = validadeDescontoCondicional;
        }

        public String getIdConta() {
            return idConta;
        }

        public void setIdConta(String idConta) {
            this.idConta = idConta;
        }

        public String getTituloRenegociado() {
            return tituloRenegociado;
        }

        public void setTituloRenegociado(String tituloRenegociado) {
            this.tituloRenegociado = tituloRenegociado;
        }

        public String getMotivoAlteracao() {
            return motivoAlteracao;
        }

        public void setMotivoAlteracao(String motivoAlteracao) {
            this.motivoAlteracao = motivoAlteracao;
        }

        public String getIdRemessaAlteracao() {
            return idRemessaAlteracao;
        }

        public void setIdRemessaAlteracao(String idRemessaAlteracao) {
            this.idRemessaAlteracao = idRemessaAlteracao;
        }

        public String getCancelamentoIdOperador() {
            return cancelamentoIdOperador;
        }

        public void setCancelamentoIdOperador(String cancelamentoIdOperador) {
            this.cancelamentoIdOperador = cancelamentoIdOperador;
        }

        public String getBaixaIdOperador() {
            return baixaIdOperador;
        }

        public void setBaixaIdOperador(String baixaIdOperador) {
            this.baixaIdOperador = baixaIdOperador;
        }

        public String getTituloImportado() {
            return tituloImportado;
        }

        public void setTituloImportado(String tituloImportado) {
            this.tituloImportado = tituloImportado;
        }

        public String getOrigemImportacao() {
            return origemImportacao;
        }

        public void setOrigemImportacao(String origemImportacao) {
            this.origemImportacao = origemImportacao;
        }

        public String getUltimaAtualizacao() {
            return ultimaAtualizacao;
        }

        public void setUltimaAtualizacao(String ultimaAtualizacao) {
            this.ultimaAtualizacao = ultimaAtualizacao;
        }

        public String getAguardandoConfirmacaoPagamento() {
            return aguardandoConfirmacaoPagamento;
        }

        public void setAguardandoConfirmacaoPagamento(String aguardandoConfirmacaoPagamento) {
            this.aguardandoConfirmacaoPagamento = aguardandoConfirmacaoPagamento;
        }

        public String getParceladoCartao() {
            return parceladoCartao;
        }

        public void setParceladoCartao(String parceladoCartao) {
            this.parceladoCartao = parceladoCartao;
        }

        public String getPixTxid() {
            return pixTxid;
        }

        public void setPixTxid(String pixTxid) {
            this.pixTxid = pixTxid;
        }

        public String getIdNotaGeradaOpc2() {
            return idNotaGeradaOpc2;
        }

        public void setIdNotaGeradaOpc2(String idNotaGeradaOpc2) {
            this.idNotaGeradaOpc2 = idNotaGeradaOpc2;
        }

        public String getIdNotaGeradaOpc3() {
            return idNotaGeradaOpc3;
        }

        public void setIdNotaGeradaOpc3(String idNotaGeradaOpc3) {
            this.idNotaGeradaOpc3 = idNotaGeradaOpc3;
        }

        public String getRecebidoViaPix() {
            return recebidoViaPix;
        }

        public void setRecebidoViaPix(String recebidoViaPix) {
            this.recebidoViaPix = recebidoViaPix;
        }

        public String getIdLoteGeracaoFinanceiroFatura() {
            return idLoteGeracaoFinanceiroFatura;
        }

        public void setIdLoteGeracaoFinanceiroFatura(String idLoteGeracaoFinanceiroFatura) {
            this.idLoteGeracaoFinanceiroFatura = idLoteGeracaoFinanceiroFatura;
        }

        
        
    }
}
