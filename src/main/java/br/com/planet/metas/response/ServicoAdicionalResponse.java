package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicoAdicionalResponse {

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

        @JsonProperty("id")
        private String id;

        @JsonProperty("tipo")
        private String tipo;

        @JsonProperty("data")
        private String data;

        @JsonProperty("id_contrato")
        private String idContrato;

        @JsonProperty("id_produto")
        private String idProduto;

        @JsonProperty("descricao")
        private String descricao;

        @JsonProperty("id_unidade")
        private String idUnidade;

        @JsonProperty("quantidade")
        private String quantidade;

        @JsonProperty("valor_unitario")
        private String valorUnitario;

        @JsonProperty("valor_total")
        private String valorTotal;

        @JsonProperty("repetir")
        private String repetir;

        @JsonProperty("repetir_qtde")
        private String repetirQtde;

        @JsonProperty("status")
        private String status;

        @JsonProperty("execucoes")
        private String execucoes;

        @JsonProperty("ultima_execucao")
        private String ultimaExecucao;

        @JsonProperty("pdesconto")
        private String percentualDesconto;

        @JsonProperty("vdesconto")
        private String valorDesconto;

        @JsonProperty("tipo_acres_desc")
        private String tipoAcresDesc;

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

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getIdContrato() {
            return idContrato;
        }

        public void setIdContrato(String idContrato) {
            this.idContrato = idContrato;
        }

        public String getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(String idProduto) {
            this.idProduto = idProduto;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getIdUnidade() {
            return idUnidade;
        }

        public void setIdUnidade(String idUnidade) {
            this.idUnidade = idUnidade;
        }

        public String getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(String quantidade) {
            this.quantidade = quantidade;
        }

        public String getValorUnitario() {
            return valorUnitario;
        }

        public void setValorUnitario(String valorUnitario) {
            this.valorUnitario = valorUnitario;
        }

        public String getValorTotal() {
            return valorTotal;
        }

        public void setValorTotal(String valorTotal) {
            this.valorTotal = valorTotal;
        }

        public String getRepetir() {
            return repetir;
        }

        public void setRepetir(String repetir) {
            this.repetir = repetir;
        }

        public String getRepetirQtde() {
            return repetirQtde;
        }

        public void setRepetirQtde(String repetirQtde) {
            this.repetirQtde = repetirQtde;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getExecucoes() {
            return execucoes;
        }

        public void setExecucoes(String execucoes) {
            this.execucoes = execucoes;
        }

        public String getUltimaExecucao() {
            return ultimaExecucao;
        }

        public void setUltimaExecucao(String ultimaExecucao) {
            this.ultimaExecucao = ultimaExecucao;
        }

        public String getPercentualDesconto() {
            return percentualDesconto;
        }

        public void setPercentualDesconto(String percentualDesconto) {
            this.percentualDesconto = percentualDesconto;
        }

        public String getValorDesconto() {
            return valorDesconto;
        }

        public void setValorDesconto(String valorDesconto) {
            this.valorDesconto = valorDesconto;
        }

        public String getTipoAcresDesc() {
            return tipoAcresDesc;
        }

        public void setTipoAcresDesc(String tipoAcresDesc) {
            this.tipoAcresDesc = tipoAcresDesc;
        }
    }
}
