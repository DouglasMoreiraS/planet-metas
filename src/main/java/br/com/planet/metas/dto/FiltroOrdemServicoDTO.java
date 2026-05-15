package br.com.planet.metas.dto;

import java.time.LocalDate;

public class FiltroOrdemServicoDTO {
    private Long atendimentoId;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Long assuntoId;
    private Long colaboradorId;
    private String status;
    private Long setorId;
    
    private LocalDate dataAgendamentoInicial;
    private LocalDate dataAgendamentoFinal;
    
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Long getAssuntoId() {
        return assuntoId;
    }

    public void setAssuntoId(Long assuntoId) {
        this.assuntoId = assuntoId;
    }

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSetorId() {
        return setorId;
    }

    public void setSetorId(Long setorId) {
        this.setorId = setorId;
    }

    public Long getAtendimentoId() {
        return atendimentoId;
    }

    public void setAtendimentoId(Long atendimentoId) {
        this.atendimentoId = atendimentoId;
    }

    public LocalDate getDataAgendamentoInicial() {
        return dataAgendamentoInicial;
    }

    public void setDataAgendamentoInicial(LocalDate dataAgendamentoInicial) {
        this.dataAgendamentoInicial = dataAgendamentoInicial;
    }

    public LocalDate getDataAgendamentoFinal() {
        return dataAgendamentoFinal;
    }

    public void setDataAgendamentoFinal(LocalDate dataAgendamentoFinal) {
        this.dataAgendamentoFinal = dataAgendamentoFinal;
    }
    
}
