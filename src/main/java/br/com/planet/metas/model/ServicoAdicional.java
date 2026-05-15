package br.com.planet.metas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicoAdicional {

    private Long id;
    private String tipo;
    private LocalDate data;
    private Long idContrato;
    private Long idProduto;
    private String descricao;
    private Long idUnidade;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private String repetir;
    private Integer repetirQtde;
    private String status;
    private Integer execucoes;
    private LocalDateTime ultimaExecucao;
    private Double percentualDesconto;
    private Double valorDesconto;
    private String tipoAcresDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getRepetir() {
        return repetir;
    }

    public void setRepetir(String repetir) {
        this.repetir = repetir;
    }

    public Integer getRepetirQtde() {
        return repetirQtde;
    }

    public void setRepetirQtde(Integer repetirQtde) {
        this.repetirQtde = repetirQtde;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExecucoes() {
        return execucoes;
    }

    public void setExecucoes(Integer execucoes) {
        this.execucoes = execucoes;
    }

    public LocalDateTime getUltimaExecucao() {
        return ultimaExecucao;
    }

    public void setUltimaExecucao(LocalDateTime ultimaExecucao) {
        this.ultimaExecucao = ultimaExecucao;
    }

    public Double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getTipoAcresDesc() {
        return tipoAcresDesc;
    }

    public void setTipoAcresDesc(String tipoAcresDesc) {
        this.tipoAcresDesc = tipoAcresDesc;
    }
}
