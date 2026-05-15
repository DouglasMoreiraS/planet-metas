package br.com.planet.metas.dto;

import java.time.LocalDate;

public class FiltroReceberDTO {
    
    private LocalDate globalInicial;
    private LocalDate globalFinal;
    private boolean negociacao;
    
    private LocalDate emissaoInicial;
    private LocalDate emissaoFinal;
    private LocalDate vencimentoInicial;
    private LocalDate vencimentoFinal;
    private LocalDate pagamentoInicial;
    private LocalDate pagamentoFinal;
    private Long contratoId;
    
    private Long contaId;

    public FiltroReceberDTO(Long contratoId) {
        this.contratoId = contratoId;
    }

    public LocalDate getEmissaoInicial() {
        return emissaoInicial;
    }

    public void setEmissaoInicial(LocalDate emissaoInicial) {
        this.emissaoInicial = emissaoInicial;
    }

    public LocalDate getEmissaoFinal() {
        return emissaoFinal;
    }

    public void setEmissaoFinal(LocalDate emissaoFinal) {
        this.emissaoFinal = emissaoFinal;
    }

    public LocalDate getVencimentoInicial() {
        return vencimentoInicial;
    }

    public void setVencimentoInicial(LocalDate validadeInicial) {
        this.vencimentoInicial = validadeInicial;
    }

    public LocalDate getVencimentoFinal() {
        return vencimentoFinal;
    }

    public void setVencimentoFinal(LocalDate validadeFinal) {
        this.vencimentoFinal = validadeFinal;
    }

    public LocalDate getPagamentoInicial() {
        return pagamentoInicial;
    }

    public void setPagamentoInicial(LocalDate pagamentoInicial) {
        this.pagamentoInicial = pagamentoInicial;
    }

    public LocalDate getPagamentoFinal() {
        return pagamentoFinal;
    }

    public void setPagamentoFinal(LocalDate pagamentoFinal) {
        this.pagamentoFinal = pagamentoFinal;
    }

    public LocalDate getGlobalInicial() {
        return globalInicial;
    }

    public void setGlobalInicial(LocalDate globalInicial) {
        this.globalInicial = globalInicial;
    }

    public LocalDate getGlobalFinal() {
        return globalFinal;
    }

    public void setGlobalFinal(LocalDate globalFinal) {
        this.globalFinal = globalFinal;
    }

    public boolean isNegociacao() {
        return negociacao;
    }

    public void setNegociacao(boolean negociacao) {
        this.negociacao = negociacao;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Long getContratoId() {
        return contratoId;
    }

    public void setContratoId(Long contratoId) {
        this.contratoId = contratoId;
    }
}
