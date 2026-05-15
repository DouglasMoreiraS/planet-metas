package br.com.planet.metas.service;

import br.com.planet.metas.integration.ProdutoContratoIntegration;
import br.com.planet.metas.model.ProdutoContrato;
import br.com.planet.metas.response.ProdutoContratoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoContratoService extends BaseService<ProdutoContrato, ProdutoContratoResponse> {

    private final ProdutoContratoIntegration integration;

    public ProdutoContratoService(ProdutoContratoIntegration integration) {
        this.integration = integration;
    }

    @Override
    public List<ProdutoContrato> listarAPI() {
        return parseResponse(integration.listar());
    }

    public ProdutoContrato buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        return listarAPI().stream()
                .filter(produto -> produto.getId() != null)
                .filter(produto -> produto.getId().toString().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<ProdutoContrato> buscarPorContratoId(Long contratoId) {
        if (contratoId == null) {
            return new ArrayList<>();
        }

        return parseResponse(integration.listarPorContratoId(contratoId));
    }

    public List<ProdutoContrato> buscarPorContratoId(String contratoId) {
        if (contratoId == null || contratoId.isBlank()) {
            return new ArrayList<>();
        }

        return buscarPorContratoId(Long.parseLong(contratoId));
    }

    @Override
    protected List<ProdutoContrato> parseResponse(ProdutoContratoResponse response) {
        try {
            List<ProdutoContrato> produtos = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return produtos;
            }

            response.getRegistros().forEach(p -> {
                ProdutoContrato produto = new ProdutoContrato();

                if (p.getId() != null && !p.getId().isBlank()) {
                    produto.setId(Long.parseLong(p.getId()));
                }

                produto.setTipo(p.getTipo());
                produto.setDescricao(p.getDescricao());
                produto.setObservacao(p.getObs());
                produto.setTipoDesconto(p.getTipoDesconto());
                produto.setUltimaAtualizacao(p.getUltimaAtualizacao());

                if (p.getIdPlano() != null && !p.getIdPlano().isBlank()) {
                    produto.setIdPlano(Long.parseLong(p.getIdPlano()));
                }

                if (p.getIdVdContrato() != null && !p.getIdVdContrato().isBlank()) {
                    produto.setIdVdContrato(Long.parseLong(p.getIdVdContrato()));
                }

                if (p.getIdProduto() != null && !p.getIdProduto().isBlank()) {
                    produto.setIdProduto(Long.parseLong(p.getIdProduto()));
                }

                if (p.getIdContrato() != null && !p.getIdContrato().isBlank()) {
                    produto.setIdContrato(Long.parseLong(p.getIdContrato()));
                }

                if (p.getQtde() != null && !p.getQtde().isBlank()) {
                    produto.setQuantidade(Double.parseDouble(p.getQtde()));
                } else {
                    produto.setQuantidade(0.0);
                }

                if (p.getValorUnit() != null && !p.getValorUnit().isBlank()) {
                    produto.setValorUnitario(Double.parseDouble(p.getValorUnit()));
                } else {
                    produto.setValorUnitario(0.0);
                }

                if (p.getValorAteVencimento() != null && !p.getValorAteVencimento().isBlank()) {
                    produto.setValorAteVencimento(Double.parseDouble(p.getValorAteVencimento()));
                } else {
                    produto.setValorAteVencimento(0.0);
                }

                if (p.getDescontoPercentual() != null && !p.getDescontoPercentual().isBlank()) {
                    produto.setDescontoPercentual(Double.parseDouble(p.getDescontoPercentual()));
                } else {
                    produto.setDescontoPercentual(0.0);
                }

                if (p.getValorDescontoProduto() != null && !p.getValorDescontoProduto().isBlank()) {
                    produto.setValorDescontoProduto(Double.parseDouble(p.getValorDescontoProduto()));
                } else {
                    produto.setValorDescontoProduto(0.0);
                }

                if (p.getIdTipoDocumento() != null && !p.getIdTipoDocumento().isBlank()) {
                    produto.setIdTipoDocumento(Long.parseLong(p.getIdTipoDocumento()));
                }

                produtos.add(produto);
            });

            return produtos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter produtos do contrato: ", e);
        }
    }

    @Override
    public ProdutoContrato salvar(ProdutoContrato object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProdutoContrato> salvar(List<ProdutoContrato> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProdutoContrato> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
