package br.com.planet.metas.model;

public class ProdutoContrato {

    private Long id;
    private String tipo;
    private Long idPlano;
    private Long idVdContrato;
    private Long idProduto;
    private Long idContrato;
    private Double quantidade;
    private Double valorUnitario;
    private String descricao;
    private String observacao;
    private Double valorAteVencimento;
    private String tipoDesconto;
    private Double descontoPercentual;
    private Double valorDescontoProduto;
    private String ultimaAtualizacao;
    private Long idTipoDocumento;

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

    public Long getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }

    public Long getIdVdContrato() {
        return idVdContrato;
    }

    public void setIdVdContrato(Long idVdContrato) {
        this.idVdContrato = idVdContrato;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValorAteVencimento() {
        return valorAteVencimento;
    }

    public void setValorAteVencimento(Double valorAteVencimento) {
        this.valorAteVencimento = valorAteVencimento;
    }

    public String getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public Double getDescontoPercentual() {
        return descontoPercentual;
    }

    public void setDescontoPercentual(Double descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

    public Double getValorDescontoProduto() {
        return valorDescontoProduto;
    }

    public void setValorDescontoProduto(Double valorDescontoProduto) {
        this.valorDescontoProduto = valorDescontoProduto;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
}
