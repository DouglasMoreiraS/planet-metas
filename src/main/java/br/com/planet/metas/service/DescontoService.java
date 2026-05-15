package br.com.planet.metas.service;

import br.com.planet.metas.integration.DescontoIntegration;
import br.com.planet.metas.model.Desconto;
import br.com.planet.metas.response.DescontoResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DescontoService extends BaseService<Desconto, DescontoResponse> {

    private final DescontoIntegration integration;

    public DescontoService(DescontoIntegration integration) {
        this.integration = integration;
    }

    @Override
    public List<Desconto> listarAPI() {
        return parseResponse(integration.listar());
    }

    public Desconto buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        return listarAPI().stream()
                .filter(desconto -> desconto.getId() != null)
                .filter(desconto -> desconto.getId().toString().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Desconto> buscarPorContratoId(Long contratoId) {
        if (contratoId == null) {
            return new ArrayList<>();
        }

        return parseResponse(integration.listarPorContratoId(contratoId));
    }

    public List<Desconto> buscarPorContratoId(String contratoId) {
        if (contratoId == null || contratoId.isBlank()) {
            return new ArrayList<>();
        }

        return buscarPorContratoId(Long.parseLong(contratoId));
    }

    @Override
    protected List<Desconto> parseResponse(DescontoResponse response) {
        try {
            List<Desconto> descontos = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return descontos;
            }

            response.getRegistros().forEach(d -> {
                Desconto desconto = new Desconto();

                if (d.getId() != null && !d.getId().isBlank()) {
                    desconto.setId(Long.parseLong(d.getId()));
                }

                desconto.setDescricao(d.getDescricao());

                if (d.getValor() != null && !d.getValor().isBlank()) {
                    desconto.setValor(Double.parseDouble(d.getValor()));
                } else {
                    desconto.setValor(0.0);
                }

                if (d.getPercentual() != null && !d.getPercentual().isBlank()) {
                    desconto.setPercentual(Double.parseDouble(d.getPercentual()));
                } else {
                    desconto.setPercentual(0.0);
                }

                if (d.getDataValidade() != null
                        && !d.getDataValidade().isBlank()
                        && !d.getDataValidade().equals("0000-00-00")) {
                    try {
                        desconto.setDataValidade(LocalDate.parse(d.getDataValidade()));
                    } catch (DateTimeParseException e) {
                        desconto.setDataValidade(null);
                    }
                }

                if (d.getIdContrato() != null && !d.getIdContrato().isBlank()) {
                    desconto.setIdContrato(Long.parseLong(d.getIdContrato()));
                }

                if (d.getIdVdContratoProdutos() != null && !d.getIdVdContratoProdutos().isBlank()) {
                    desconto.setIdVdContratoProdutos(Long.parseLong(d.getIdVdContratoProdutos()));
                }

                descontos.add(desconto);
            });

            return descontos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter descontos: ", e);
        }
    }

    @Override
    public Desconto salvar(Desconto object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Desconto> salvar(List<Desconto> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Desconto> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
