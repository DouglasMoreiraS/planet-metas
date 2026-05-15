package br.com.planet.metas.service;

import br.com.planet.metas.integration.AcrescimoIntegration;
import br.com.planet.metas.model.Acrescimo;
import br.com.planet.metas.response.AcrescimoResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AcrescimoService extends BaseService<Acrescimo, AcrescimoResponse> {

    private final AcrescimoIntegration integration;

    public AcrescimoService(AcrescimoIntegration integration) {
        this.integration = integration;
    }

    @Override
    public List<Acrescimo> listarAPI() {
        return parseResponse(integration.listar());
    }

    public Acrescimo buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        return listarAPI().stream()
                .filter(acrescimo -> acrescimo.getId() != null)
                .filter(acrescimo -> acrescimo.getId().toString().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Acrescimo> buscarPorContratoId(Long contratoId) {
        if (contratoId == null) {
            return new ArrayList<>();
        }

        return parseResponse(integration.listarPorContratoId(contratoId));
    }

    public List<Acrescimo> buscarPorContratoId(String contratoId) {
        if (contratoId == null || contratoId.isBlank()) {
            return new ArrayList<>();
        }

        return buscarPorContratoId(Long.parseLong(contratoId));
    }

    @Override
    protected List<Acrescimo> parseResponse(AcrescimoResponse response) {
        try {
            List<Acrescimo> acrescimos = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return acrescimos;
            }

            response.getRegistros().forEach(a -> {
                Acrescimo acrescimo = new Acrescimo();

                if (a.getId() != null && !a.getId().isBlank()) {
                    acrescimo.setId(Long.parseLong(a.getId()));
                }

                acrescimo.setDescricao(a.getDescricao());

                if (a.getValor() != null && !a.getValor().isBlank()) {
                    acrescimo.setValor(Double.parseDouble(a.getValor()));
                } else {
                    acrescimo.setValor(0.0);
                }

                if (a.getPercentual() != null && !a.getPercentual().isBlank()) {
                    acrescimo.setPercentual(Double.parseDouble(a.getPercentual()));
                } else {
                    acrescimo.setPercentual(0.0);
                }

                if (a.getData() != null
                        && !a.getData().isBlank()
                        && !a.getData().equals("0000-00-00")) {
                    try {
                        acrescimo.setData(LocalDate.parse(a.getData()));
                    } catch (DateTimeParseException e) {
                        acrescimo.setData(null);
                    }
                }

                if (a.getDataValidade() != null
                        && !a.getDataValidade().isBlank()
                        && !a.getDataValidade().equals("0000-00-00")) {
                    try {
                        acrescimo.setDataValidade(LocalDate.parse(a.getDataValidade()));
                    } catch (DateTimeParseException e) {
                        acrescimo.setDataValidade(null);
                    }
                }

                if (a.getIdContrato() != null && !a.getIdContrato().isBlank()) {
                    acrescimo.setIdContrato(Long.parseLong(a.getIdContrato()));
                }

                if (a.getIdVdContratoProdutos() != null && !a.getIdVdContratoProdutos().isBlank()) {
                    acrescimo.setIdVdContratoProdutos(Long.parseLong(a.getIdVdContratoProdutos()));
                }

                if (a.getIdReajuste() != null && !a.getIdReajuste().isBlank()) {
                    acrescimo.setIdReajuste(Long.parseLong(a.getIdReajuste()));
                }

                acrescimos.add(acrescimo);
            });

            return acrescimos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter acréscimos: ", e);
        }
    }

    @Override
    public Acrescimo salvar(Acrescimo object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Acrescimo> salvar(List<Acrescimo> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Acrescimo> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
