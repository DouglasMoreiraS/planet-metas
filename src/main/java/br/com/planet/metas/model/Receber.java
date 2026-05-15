package br.com.planet.metas.model;

import java.time.LocalDate;

public class Receber {

    public static final String A_RECEBER = "A";
    public static final String RECEBIMENTO_EM_DIA = "R";
    public static final String RENEGOCIACAO_1 = "Renegociação 1";
    public static final String RENEGOCIACAO_2 = "Renegociação 2";

    private String responsavelRenegociacao;

    private Long id;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private double valor;
    private double valorRecebido;
    private double valorAberto;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public double getValorAberto() {
        return valorAberto;
    }

    public void setValorAberto(double valorAberto) {
        this.valorAberto = valorAberto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsavelRenegociacao() {
        return responsavelRenegociacao;
    }

    public void setResponsavelRenegociacao(String responsavelRenegociacao) {
        this.responsavelRenegociacao = responsavelRenegociacao;
    }

}
