package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdemServicoResponse {

    private String page;
    private int total;

    @JsonProperty("registros")
    private List<RegistrosResponse> registros;

    // Getters e setters
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<br.com.planet.metas.response.RegistrosResponse> getRegistros() {
        return registros;
    }

    public void setRegistros(List<br.com.planet.metas.response.RegistrosResponse> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        return "OrdemServicoResponse{" + "page=" + page + ", total=" + total + ", registros=" + registros.size() + '}';
    }
    
}
