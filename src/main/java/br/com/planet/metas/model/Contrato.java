package br.com.planet.metas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private Long id;
    private String statusContrato;
    private String statusAcesso;
    private LocalDate dataAtivacao;
    private LocalDate dataCancelamento;
    private String plano;
    private String bairro;
    private Double valorPlano;

    private Vendedor vendedor;
    private PlanoVenda planoVenda;
    private List<ProdutoContrato> produtos = new ArrayList<>();
    private List<Acrescimo> acrescimos = new ArrayList<>();
    private List<Desconto> descontos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public String getStatusAcesso() {
        return statusAcesso;
    }

    public void setStatusAcesso(String statusAcesso) {
        this.statusAcesso = statusAcesso;
    }

    public LocalDate getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public LocalDate getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(LocalDate dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Double getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(Double valorPlano) {
        this.valorPlano = valorPlano;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public PlanoVenda getPlanoVenda() {
        return planoVenda;
    }

    public void setPlanoVenda(PlanoVenda planoVenda) {
        this.planoVenda = planoVenda;
    }

    public List<ProdutoContrato> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoContrato> produtos) {
        this.produtos = produtos;
    }

    public List<Acrescimo> getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(List<Acrescimo> acrescimos) {
        this.acrescimos = acrescimos;
    }

    public List<Desconto> getDescontos() {
        return descontos;
    }

    public void setDescontos(List<Desconto> descontos) {
        this.descontos = descontos;
    }

}
