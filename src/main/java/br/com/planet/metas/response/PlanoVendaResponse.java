package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanoVendaResponse {

    @JsonProperty("page")
    private String page;

    @JsonProperty("total")
    private String total;

    @JsonProperty("registros")
    private List<Registro> registros;

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

        @JsonProperty("fidelidade")
        private String fidelidade;

        @JsonProperty("id")
        private String id;

        @JsonProperty("nome")
        private String nome;

        @JsonProperty("descricao")
        private String descricao;

        @JsonProperty("tipo_pessoa")
        private String tipoPessoa;

        @JsonProperty("moeda")
        private String moeda;

        @JsonProperty("valor_contrato")
        private String valorContrato;

        @JsonProperty("Ativo")
        private String ativo;

        @JsonProperty("id_tipo_documento")
        private String idTipoDocumento;

        @JsonProperty("id_carteira_cobranca")
        private String idCarteiraCobranca;

        @JsonProperty("id_vendedor")
        private String idVendedor;

        @JsonProperty("comissao")
        private String comissao;

        @JsonProperty("id_modelo")
        private String idModelo;

        @JsonProperty("limitar_n_logins")
        private String limitarNLogins;

        @JsonProperty("tipo_doc_opc")
        private String tipoDocOpc;

        @JsonProperty("logins_simultaneos")
        private String loginsSimultaneos;

        @JsonProperty("tipo_doc_opc2")
        private String tipoDocOpc2;

        @JsonProperty("tipo")
        private String tipo;

        @JsonProperty("tipo_doc_opc3")
        private String tipoDocOpc3;

        @JsonProperty("tel_franquia_segundos")
        private String telFranquiaSegundos;

        @JsonProperty("tipo_doc_opc4")
        private String tipoDocOpc4;

        @JsonProperty("tel_franquia_prefix")
        private String telFranquiaPrefix;

        @JsonProperty("id_tipo_doc_ativ")
        private String idTipoDocAtiv;

        @JsonProperty("id_cidade")
        private String idCidade;

        @JsonProperty("id_produto_ativ")
        private String idProdutoAtiv;

        @JsonProperty("id_cond_pag_ativ")
        private String idCondPagAtiv;

        @JsonProperty("id_vendedor_ativ")
        private String idVendedorAtiv;

        @JsonProperty("ultima_atualizacao")
        private String ultimaAtualizacao;

        @JsonProperty("id_filial")
        private String idFilial;

        @JsonProperty("utilizar_desconto_ate_vencimento")
        private String utilizarDescontoAteVencimento;

        @JsonProperty("id_produto_ate_vencimento")
        private String idProdutoAteVencimento;

        @JsonProperty("valor_desconto")
        private String valorDesconto;

        @JsonProperty("utilizar_desconto_por_repeticao")
        private String utilizarDescontoPorRepeticao;

        @JsonProperty("qtde_repeticoes_desconto")
        private String qtdeRepeticoesDesconto;

        @JsonProperty("id_produto_contrato_vinc")
        private String idProdutoContratoVinc;

        @JsonProperty("utilizar_desconto_no_produto_plano")
        private String utilizarDescontoNoProdutoPlano;

        @JsonProperty("base_geracao_por_tipo_doc")
        private String baseGeracaoPorTipoDoc;

        public String getFidelidade() {
            return fidelidade;
        }

        public void setFidelidade(String fidelidade) {
            this.fidelidade = fidelidade;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getTipoPessoa() {
            return tipoPessoa;
        }

        public void setTipoPessoa(String tipoPessoa) {
            this.tipoPessoa = tipoPessoa;
        }

        public String getMoeda() {
            return moeda;
        }

        public void setMoeda(String moeda) {
            this.moeda = moeda;
        }

        public String getValorContrato() {
            return valorContrato;
        }

        public void setValorContrato(String valorContrato) {
            this.valorContrato = valorContrato;
        }

        public String getAtivo() {
            return ativo;
        }

        public void setAtivo(String ativo) {
            this.ativo = ativo;
        }

        public String getIdTipoDocumento() {
            return idTipoDocumento;
        }

        public void setIdTipoDocumento(String idTipoDocumento) {
            this.idTipoDocumento = idTipoDocumento;
        }

        public String getIdCarteiraCobranca() {
            return idCarteiraCobranca;
        }

        public void setIdCarteiraCobranca(String idCarteiraCobranca) {
            this.idCarteiraCobranca = idCarteiraCobranca;
        }

        public String getIdVendedor() {
            return idVendedor;
        }

        public void setIdVendedor(String idVendedor) {
            this.idVendedor = idVendedor;
        }

        public String getComissao() {
            return comissao;
        }

        public void setComissao(String comissao) {
            this.comissao = comissao;
        }

        public String getIdModelo() {
            return idModelo;
        }

        public void setIdModelo(String idModelo) {
            this.idModelo = idModelo;
        }

        public String getLimitarNLogins() {
            return limitarNLogins;
        }

        public void setLimitarNLogins(String limitarNLogins) {
            this.limitarNLogins = limitarNLogins;
        }

        public String getTipoDocOpc() {
            return tipoDocOpc;
        }

        public void setTipoDocOpc(String tipoDocOpc) {
            this.tipoDocOpc = tipoDocOpc;
        }

        public String getLoginsSimultaneos() {
            return loginsSimultaneos;
        }

        public void setLoginsSimultaneos(String loginsSimultaneos) {
            this.loginsSimultaneos = loginsSimultaneos;
        }

        public String getTipoDocOpc2() {
            return tipoDocOpc2;
        }

        public void setTipoDocOpc2(String tipoDocOpc2) {
            this.tipoDocOpc2 = tipoDocOpc2;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getTipoDocOpc3() {
            return tipoDocOpc3;
        }

        public void setTipoDocOpc3(String tipoDocOpc3) {
            this.tipoDocOpc3 = tipoDocOpc3;
        }

        public String getTelFranquiaSegundos() {
            return telFranquiaSegundos;
        }

        public void setTelFranquiaSegundos(String telFranquiaSegundos) {
            this.telFranquiaSegundos = telFranquiaSegundos;
        }

        public String getTipoDocOpc4() {
            return tipoDocOpc4;
        }

        public void setTipoDocOpc4(String tipoDocOpc4) {
            this.tipoDocOpc4 = tipoDocOpc4;
        }

        public String getTelFranquiaPrefix() {
            return telFranquiaPrefix;
        }

        public void setTelFranquiaPrefix(String telFranquiaPrefix) {
            this.telFranquiaPrefix = telFranquiaPrefix;
        }

        public String getIdTipoDocAtiv() {
            return idTipoDocAtiv;
        }

        public void setIdTipoDocAtiv(String idTipoDocAtiv) {
            this.idTipoDocAtiv = idTipoDocAtiv;
        }

        public String getIdCidade() {
            return idCidade;
        }

        public void setIdCidade(String idCidade) {
            this.idCidade = idCidade;
        }

        public String getIdProdutoAtiv() {
            return idProdutoAtiv;
        }

        public void setIdProdutoAtiv(String idProdutoAtiv) {
            this.idProdutoAtiv = idProdutoAtiv;
        }

        public String getIdCondPagAtiv() {
            return idCondPagAtiv;
        }

        public void setIdCondPagAtiv(String idCondPagAtiv) {
            this.idCondPagAtiv = idCondPagAtiv;
        }

        public String getIdVendedorAtiv() {
            return idVendedorAtiv;
        }

        public void setIdVendedorAtiv(String idVendedorAtiv) {
            this.idVendedorAtiv = idVendedorAtiv;
        }

        public String getUltimaAtualizacao() {
            return ultimaAtualizacao;
        }

        public void setUltimaAtualizacao(String ultimaAtualizacao) {
            this.ultimaAtualizacao = ultimaAtualizacao;
        }

        public String getIdFilial() {
            return idFilial;
        }

        public void setIdFilial(String idFilial) {
            this.idFilial = idFilial;
        }

        public String getUtilizarDescontoAteVencimento() {
            return utilizarDescontoAteVencimento;
        }

        public void setUtilizarDescontoAteVencimento(String utilizarDescontoAteVencimento) {
            this.utilizarDescontoAteVencimento = utilizarDescontoAteVencimento;
        }

        public String getIdProdutoAteVencimento() {
            return idProdutoAteVencimento;
        }

        public void setIdProdutoAteVencimento(String idProdutoAteVencimento) {
            this.idProdutoAteVencimento = idProdutoAteVencimento;
        }

        public String getValorDesconto() {
            return valorDesconto;
        }

        public void setValorDesconto(String valorDesconto) {
            this.valorDesconto = valorDesconto;
        }

        public String getUtilizarDescontoPorRepeticao() {
            return utilizarDescontoPorRepeticao;
        }

        public void setUtilizarDescontoPorRepeticao(String utilizarDescontoPorRepeticao) {
            this.utilizarDescontoPorRepeticao = utilizarDescontoPorRepeticao;
        }

        public String getQtdeRepeticoesDesconto() {
            return qtdeRepeticoesDesconto;
        }

        public void setQtdeRepeticoesDesconto(String qtdeRepeticoesDesconto) {
            this.qtdeRepeticoesDesconto = qtdeRepeticoesDesconto;
        }

        public String getIdProdutoContratoVinc() {
            return idProdutoContratoVinc;
        }

        public void setIdProdutoContratoVinc(String idProdutoContratoVinc) {
            this.idProdutoContratoVinc = idProdutoContratoVinc;
        }

        public String getUtilizarDescontoNoProdutoPlano() {
            return utilizarDescontoNoProdutoPlano;
        }

        public void setUtilizarDescontoNoProdutoPlano(String utilizarDescontoNoProdutoPlano) {
            this.utilizarDescontoNoProdutoPlano = utilizarDescontoNoProdutoPlano;
        }

        public String getBaseGeracaoPorTipoDoc() {
            return baseGeracaoPorTipoDoc;
        }

        public void setBaseGeracaoPorTipoDoc(String baseGeracaoPorTipoDoc) {
            this.baseGeracaoPorTipoDoc = baseGeracaoPorTipoDoc;
        }

    }

}