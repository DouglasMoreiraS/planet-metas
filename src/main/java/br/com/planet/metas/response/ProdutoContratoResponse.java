package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProdutoContratoResponse {

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

        @JsonProperty("descricao_plano_valor_1")
        private String descricaoPlanoValor1;

        @JsonProperty("descricao_plano_valor_2")
        private String descricaoPlanoValor2;

        @JsonProperty("fixar_ip")
        private String fixarIp;

        @JsonProperty("tipo_desconto")
        private String tipoDesconto;

        @JsonProperty("desconto_percentual")
        private String descontoPercentual;

        @JsonProperty("repetir")
        private String repetir;

        @JsonProperty("id")
        private String id;

        @JsonProperty("tipo")
        private String tipo;

        @JsonProperty("id_plano")
        private String idPlano;

        @JsonProperty("id_vd_contrato")
        private String idVdContrato;

        @JsonProperty("id_produto")
        private String idProduto;

        @JsonProperty("qtde")
        private String qtde;

        @JsonProperty("valor_unit")
        private String valorUnit;

        @JsonProperty("descricao")
        private String descricao;

        @JsonProperty("id_contrato")
        private String idContrato;

        @JsonProperty("obs")
        private String obs;

        @JsonProperty("valor_ate_vencimento")
        private String valorAteVencimento;

        @JsonProperty("qtde_repeticoes_desconto_produto")
        private String qtdeRepeticoesDescontoProduto;

        @JsonProperty("valor_desconto_produto")
        private String valorDescontoProduto;

        @JsonProperty("ultima_atualizacao")
        private String ultimaAtualizacao;

        @JsonProperty("id_tipo_documento")
        private String idTipoDocumento;

        public String getDescricaoPlanoValor1() {
            return descricaoPlanoValor1;
        }

        public void setDescricaoPlanoValor1(String descricaoPlanoValor1) {
            this.descricaoPlanoValor1 = descricaoPlanoValor1;
        }

        public String getDescricaoPlanoValor2() {
            return descricaoPlanoValor2;
        }

        public void setDescricaoPlanoValor2(String descricaoPlanoValor2) {
            this.descricaoPlanoValor2 = descricaoPlanoValor2;
        }

        public String getFixarIp() {
            return fixarIp;
        }

        public void setFixarIp(String fixarIp) {
            this.fixarIp = fixarIp;
        }

        public String getTipoDesconto() {
            return tipoDesconto;
        }

        public void setTipoDesconto(String tipoDesconto) {
            this.tipoDesconto = tipoDesconto;
        }

        public String getDescontoPercentual() {
            return descontoPercentual;
        }

        public void setDescontoPercentual(String descontoPercentual) {
            this.descontoPercentual = descontoPercentual;
        }

        public String getRepetir() {
            return repetir;
        }

        public void setRepetir(String repetir) {
            this.repetir = repetir;
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

        public String getIdPlano() {
            return idPlano;
        }

        public void setIdPlano(String idPlano) {
            this.idPlano = idPlano;
        }

        public String getIdVdContrato() {
            return idVdContrato;
        }

        public void setIdVdContrato(String idVdContrato) {
            this.idVdContrato = idVdContrato;
        }

        public String getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(String idProduto) {
            this.idProduto = idProduto;
        }

        public String getQtde() {
            return qtde;
        }

        public void setQtde(String qtde) {
            this.qtde = qtde;
        }

        public String getValorUnit() {
            return valorUnit;
        }

        public void setValorUnit(String valorUnit) {
            this.valorUnit = valorUnit;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getIdContrato() {
            return idContrato;
        }

        public void setIdContrato(String idContrato) {
            this.idContrato = idContrato;
        }

        public String getObs() {
            return obs;
        }

        public void setObs(String obs) {
            this.obs = obs;
        }

        public String getValorAteVencimento() {
            return valorAteVencimento;
        }

        public void setValorAteVencimento(String valorAteVencimento) {
            this.valorAteVencimento = valorAteVencimento;
        }

        public String getQtdeRepeticoesDescontoProduto() {
            return qtdeRepeticoesDescontoProduto;
        }

        public void setQtdeRepeticoesDescontoProduto(String qtdeRepeticoesDescontoProduto) {
            this.qtdeRepeticoesDescontoProduto = qtdeRepeticoesDescontoProduto;
        }

        public String getValorDescontoProduto() {
            return valorDescontoProduto;
        }

        public void setValorDescontoProduto(String valorDescontoProduto) {
            this.valorDescontoProduto = valorDescontoProduto;
        }

        public String getUltimaAtualizacao() {
            return ultimaAtualizacao;
        }

        public void setUltimaAtualizacao(String ultimaAtualizacao) {
            this.ultimaAtualizacao = ultimaAtualizacao;
        }

        public String getIdTipoDocumento() {
            return idTipoDocumento;
        }

        public void setIdTipoDocumento(String idTipoDocumento) {
            this.idTipoDocumento = idTipoDocumento;
        }
    }
}
