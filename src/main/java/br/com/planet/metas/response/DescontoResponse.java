package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DescontoResponse {

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

        @JsonProperty("descricao")
        private String descricao;

        @JsonProperty("valor")
        private String valor;

        @JsonProperty("percentual")
        private String percentual;

        @JsonProperty("data_validade")
        private String dataValidade;

        @JsonProperty("id_contrato")
        private String idContrato;

        @JsonProperty("id_vd_contrato_produtos")
        private String idVdContratoProdutos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public String getPercentual() {
            return percentual;
        }

        public void setPercentual(String percentual) {
            this.percentual = percentual;
        }

        public String getDataValidade() {
            return dataValidade;
        }

        public void setDataValidade(String dataValidade) {
            this.dataValidade = dataValidade;
        }

        public String getIdContrato() {
            return idContrato;
        }

        public void setIdContrato(String idContrato) {
            this.idContrato = idContrato;
        }

        public String getIdVdContratoProdutos() {
            return idVdContratoProdutos;
        }

        public void setIdVdContratoProdutos(String idVdContratoProdutos) {
            this.idVdContratoProdutos = idVdContratoProdutos;
        }
    }
}