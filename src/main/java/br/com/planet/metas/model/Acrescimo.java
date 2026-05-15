package br.com.planet.metas.model;

import java.time.LocalDate;

public class Acrescimo {

    private Long id;
    private String descricao;
    private Double valor;
    private Double percentual;
    private LocalDate data;
    private LocalDate dataValidade;
    private Long idContrato;
    private Long idVdContratoProdutos;
    private Long idReajuste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Long getIdVdContratoProdutos() {
        return idVdContratoProdutos;
    }

    public void setIdVdContratoProdutos(Long idVdContratoProdutos) {
        this.idVdContratoProdutos = idVdContratoProdutos;
    }

    public Long getIdReajuste() {
        return idReajuste;
    }

    public void setIdReajuste(Long idReajuste) {
        this.idReajuste = idReajuste;
    }
}