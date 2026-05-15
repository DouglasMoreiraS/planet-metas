package br.com.planet.metas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "meta_report_cache",
        indexes = {
                @Index(name = "idx_meta_report_cache_data_instalacao", columnList = "data_instalacao"),
                @Index(name = "idx_meta_report_cache_contrato", columnList = "contrato_id")
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_meta_report_cache_contrato_os",
                        columnNames = {"contrato_id", "ordem_servico_id"}
                )
        }
)
public class MetaReportCache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contrato_id", nullable = false)
    private Long contratoId;

    @Column(name = "ordem_servico_id")
    private Long ordemServicoId;

    @Column(name = "data_instalacao")
    private LocalDate dataInstalacao;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "nome_vendedor")
    private String nomeVendedor;

    //IA: Persiste o tipo para permitir filtros sem depender de nova consulta na IXC.
    @Column(name = "tipo_vendedor")
    private Integer tipoVendedor;

    @Column(name = "nome_plano")
    private String nomePlano;

    private Double ticket;

    private Double pontos;

    private String status;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    @PreUpdate
    public void atualizarDataAtualizacao() {
        atualizadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContratoId() {
        return contratoId;
    }

    public void setContratoId(Long contratoId) {
        this.contratoId = contratoId;
    }

    public Long getOrdemServicoId() {
        return ordemServicoId;
    }

    public void setOrdemServicoId(Long ordemServicoId) {
        this.ordemServicoId = ordemServicoId;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
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

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
