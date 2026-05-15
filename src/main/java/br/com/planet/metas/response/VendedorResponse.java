package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VendedorResponse {

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

        @JsonProperty("pipe_id_usuario")
        private String pipeIdUsuario;

        @JsonProperty("id")
        private String id;

        @JsonProperty("nome")
        private String nome;

        @JsonProperty("comissao_perc_recebimento")
        private String comissaoPercRecebimento;

        @JsonProperty("comissao")
        private String comissao;

        @JsonProperty("endereco")
        private String endereco;

        @JsonProperty("comissao_v")
        private String comissaoV;

        @JsonProperty("bairro")
        private String bairro;

        @JsonProperty("status")
        private String status;

        @JsonProperty("id_cidade")
        private String idCidade;

        @JsonProperty("cor_no_mapa")
        private String corNoMapa;

        @JsonProperty("telefone")
        private String telefone;

        @JsonProperty("ultima_atualizacao")
        private String ultimaAtualizacao;

        @JsonProperty("celular")
        private String celular;

        @JsonProperty("cnpj_cpf")
        private String cnpjCpf;

        @JsonProperty("ie_rg")
        private String ieRg;

        @JsonProperty("email")
        private String email;

        // Getters e setters
        public String getPipeIdUsuario() {
            return pipeIdUsuario;
        }

        public void setPipeIdUsuario(String pipeIdUsuario) {
            this.pipeIdUsuario = pipeIdUsuario;
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

        public String getComissaoPercRecebimento() {
            return comissaoPercRecebimento;
        }

        public void setComissaoPercRecebimento(String comissaoPercRecebimento) {
            this.comissaoPercRecebimento = comissaoPercRecebimento;
        }

        public String getComissao() {
            return comissao;
        }

        public void setComissao(String comissao) {
            this.comissao = comissao;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getComissaoV() {
            return comissaoV;
        }

        public void setComissaoV(String comissaoV) {
            this.comissaoV = comissaoV;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIdCidade() {
            return idCidade;
        }

        public void setIdCidade(String idCidade) {
            this.idCidade = idCidade;
        }

        public String getCorNoMapa() {
            return corNoMapa;
        }

        public void setCorNoMapa(String corNoMapa) {
            this.corNoMapa = corNoMapa;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getUltimaAtualizacao() {
            return ultimaAtualizacao;
        }

        public void setUltimaAtualizacao(String ultimaAtualizacao) {
            this.ultimaAtualizacao = ultimaAtualizacao;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getCnpjCpf() {
            return cnpjCpf;
        }

        public void setCnpjCpf(String cnpjCpf) {
            this.cnpjCpf = cnpjCpf;
        }

        public String getIeRg() {
            return ieRg;
        }

        public void setIeRg(String ieRg) {
            this.ieRg = ieRg;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
