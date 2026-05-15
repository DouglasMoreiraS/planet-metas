package br.com.planet.metas.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MetasDashboardDTO {

    private List<MetaReportData> relatorio;
    private List<br.com.planet.metas.dto.PontuacaoVendedorDTO> pontuacoes;
    private LocalDateTime ultimaAtualizacao;

    public MetasDashboardDTO() {
    }

    public MetasDashboardDTO(
            List<MetaReportData> relatorio,
            List<PontuacaoVendedorDTO> pontuacoes
    ) {
        this.relatorio = relatorio;
        this.pontuacoes = pontuacoes;
    }

    public MetasDashboardDTO(
            List<MetaReportData> relatorio,
            List<PontuacaoVendedorDTO> pontuacoes,
            LocalDateTime ultimaAtualizacao
    ) {
        this.relatorio = relatorio;
        this.pontuacoes = pontuacoes;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public List<MetaReportData> getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(List<MetaReportData> relatorio) {
        this.relatorio = relatorio;
    }

    public List<PontuacaoVendedorDTO> getPontuacoes() {
        return pontuacoes;
    }

    public void setPontuacoes(List<PontuacaoVendedorDTO> pontuacoes) {
        this.pontuacoes = pontuacoes;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
