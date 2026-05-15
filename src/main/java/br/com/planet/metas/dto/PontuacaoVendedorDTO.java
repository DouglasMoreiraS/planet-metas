package br.com.planet.metas.dto;

public class PontuacaoVendedorDTO {

    private String nomeVendedor;
    private Double pontosTotais;

    public PontuacaoVendedorDTO() {
    }

    public PontuacaoVendedorDTO(String nomeVendedor, Double pontosTotais) {
        this.nomeVendedor = nomeVendedor;
        this.pontosTotais = pontosTotais;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Double getPontosTotais() {
        return pontosTotais;
    }

    public void setPontosTotais(Double pontosTotais) {
        this.pontosTotais = pontosTotais;
    }
}
