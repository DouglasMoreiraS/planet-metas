package br.com.planet.metas.service;

import br.com.planet.metas.integration.PlanoVendaIntegration;
import br.com.planet.metas.model.PlanoVenda;
import br.com.planet.metas.response.PlanoVendaResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanoVendaService extends BaseService<PlanoVenda, PlanoVendaResponse> {

    private final PlanoVendaIntegration integration;

    public PlanoVendaService(PlanoVendaIntegration integration) {
        this.integration = integration;
    }

    @Override
    public List<PlanoVenda> listarAPI() {
        return parseResponse(integration.listar());
    }

    public PlanoVenda buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        return buscarPorId(Long.parseLong(id));
    }

    public PlanoVenda buscarPorId(Long id) {
        if (id == null) {
            return null;
        }

        return parseResponse(integration.buscarPorId(id)).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    protected List<PlanoVenda> parseResponse(PlanoVendaResponse response) {
        try {
            List<PlanoVenda> planos = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return planos;
            }

            response.getRegistros().forEach(p -> {
                PlanoVenda plano = new PlanoVenda();

                if (p.getId() != null && !p.getId().isBlank()) {
                    plano.setId(Long.parseLong(p.getId()));
                }

                plano.setNome(p.getNome());
                plano.setDescricao(p.getDescricao());
                plano.setAtivo(p.getAtivo());
                plano.setTipoPessoa(p.getTipoPessoa());
                plano.setMoeda(p.getMoeda());
                plano.setIdFilial(p.getIdFilial());

                if (p.getValorContrato() != null && !p.getValorContrato().isBlank()) {
                    plano.setValorContrato(Double.parseDouble(p.getValorContrato()));
                } else {
                    plano.setValorContrato(0.0);
                }

                planos.add(plano);
            });

            return planos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter planos de venda: ", e);
        }
    }

    @Override
    public PlanoVenda salvar(PlanoVenda object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PlanoVenda> salvar(List<PlanoVenda> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PlanoVenda> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}