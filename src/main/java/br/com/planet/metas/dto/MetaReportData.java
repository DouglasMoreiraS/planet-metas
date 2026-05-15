package br.com.planet.metas.dto;

import java.time.LocalDate;

public class MetaReportData {

    private LocalDate dataInstalacao;
    private Long ordemServicoId;
    private Long idContrato;
    private String nomeCliente;
    private String nomePlano;
    private String nomeVendedor;
    //IA: Mantem a classificacao do vendedor no relatorio para filtros por interno/externo.
    private Integer tipoVendedor;
    private Double ticket;
    private Double pontos;
    private String status;

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Long getOrdemServicoId() {
        return ordemServicoId;
    }

    public void setOrdemServicoId(Long ordemServicoId) {
        this.ordemServicoId = ordemServicoId;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Integer getTipoVendedor() {
        return tipoVendedor;
    }

    public void setTipoVendedor(Integer tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }

    public Double getTicket() {
        return ticket;
    }

    public void setTicket(Double ticket) {
        this.ticket = ticket;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MetaReportData{" +
                "dataInstalacao=" + dataInstalacao +
                ", ordemServicoId=" + ordemServicoId +
                ", idContrato=" + idContrato +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", nomePlano='" + nomePlano + '\'' +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                ", tipoVendedor=" + tipoVendedor +
                ", ticket=" + ticket +
                ", pontos=" + pontos +
                ", status='" + status + '\'' +
                '}';
    }
}
