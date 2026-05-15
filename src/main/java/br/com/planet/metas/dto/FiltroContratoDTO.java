package br.com.planet.metas.dto;

import java.time.LocalDate;

public class FiltroContratoDTO {
    
    public static final String STATUS_CONTRATO_ATIVO = "A";
    public static final String STATUS_CONTRATO_INATIVO = "I";
    public static final String STATUS_ACESSO_DESATIVADO = "D";
    public static final String STATUS_ACESSO_BLOQUEIO_MANUAL = "CM";
    public static final String STATUS_ACESSO_BLOQUEIO_AUTO = "CA";
    public static final String STATUS_ACESSO_FINANCEIRO_ATRASO = "FA";
    
    private Long id;
    private LocalDate dataInicialAtivacao;
    private LocalDate dataFinalAtivacao;
    private String statusContrato;
    private String statusAcesso;
    private Long vendedorId;
    private Long planoId;
    private LocalDate dataInicialCancelamento;
    private LocalDate dataFinalCancelamento;
    private String bairro;
    private String plano;
    private Long clienteId;
    private Long motivoCancelamentoId;
    private Long colaboradorCancelamentoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicialAtivacao() {
        return dataInicialAtivacao;
    }

    public void setDataInicialAtivacao(LocalDate dataInicial) {
        this.dataInicialAtivacao = dataInicial;
    }

    public LocalDate getDataFinalAtivacao() {
        return dataFinalAtivacao;
    }

    public void setDataFinalAtivacao(LocalDate dataFinal) {
        this.dataFinalAtivacao = dataFinal;
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

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }

    public LocalDate getDataInicialCancelamento() {
        return dataInicialCancelamento;
    }

    public void setDataInicialCancelamento(LocalDate dataInicialCancelamento) {
        this.dataInicialCancelamento = dataInicialCancelamento;
    }

    public LocalDate getDataFinalCancelamento() {
        return dataFinalCancelamento;
    }

    public void setDataFinalCancelamento(LocalDate dataFinalCancelamento) {
        this.dataFinalCancelamento = dataFinalCancelamento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getMotivoCancelamentoId() {
        return motivoCancelamentoId;
    }

    public void setMotivoCancelamentoId(Long motivoCancelamentoId) {
        this.motivoCancelamentoId = motivoCancelamentoId;
    }

    public Long getColaboradorCancelamentoId() {
        return colaboradorCancelamentoId;
    }

    public void setColaboradorCancelamentoId(Long colaboradorCancelamentoId) {
        this.colaboradorCancelamentoId = colaboradorCancelamentoId;
    }
    
    
    
}
