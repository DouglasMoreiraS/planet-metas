package br.com.planet.metas.service;

import br.com.planet.metas.integration.ServicoAdicionalIntegration;
import br.com.planet.metas.model.ServicoAdicional;
import br.com.planet.metas.response.ServicoAdicionalResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoAdicionalService extends BaseService<ServicoAdicional, ServicoAdicionalResponse> {

    private final ServicoAdicionalIntegration integration;

    public ServicoAdicionalService(ServicoAdicionalIntegration integration) {
        this.integration = integration;
    }

    @Override
    public List<ServicoAdicional> listarAPI() {
        return parseResponse(integration.listar());
    }

    public List<ServicoAdicional> buscarPorContratoId(Long contratoId) {
        if (contratoId == null) {
            return new ArrayList<>();
        }

        return parseResponse(integration.listarPorContratoId(contratoId));
    }

    public List<ServicoAdicional> buscarPorContratoId(String contratoId) {
        if (contratoId == null || contratoId.isBlank()) {
            return new ArrayList<>();
        }

        return buscarPorContratoId(Long.parseLong(contratoId));
    }

    @Override
    protected List<ServicoAdicional> parseResponse(ServicoAdicionalResponse response) {
        try {
            List<ServicoAdicional> servicos = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return servicos;
            }

            response.getRegistros().forEach(r -> {
                ServicoAdicional servico = new ServicoAdicional();

                servico.setId(parseLong(r.getId()));
                servico.setTipo(r.getTipo());
                servico.setData(parseLocalDate(r.getData()));
                servico.setIdContrato(parseLong(r.getIdContrato()));
                servico.setIdProduto(parseLong(r.getIdProduto()));
                servico.setDescricao(r.getDescricao());
                servico.setIdUnidade(parseLong(r.getIdUnidade()));
                servico.setQuantidade(parseDouble(r.getQuantidade()));
                servico.setValorUnitario(parseDouble(r.getValorUnitario()));
                servico.setValorTotal(parseDouble(r.getValorTotal()));
                servico.setRepetir(r.getRepetir());
                servico.setRepetirQtde(parseInteger(r.getRepetirQtde()));
                servico.setStatus(r.getStatus());
                servico.setExecucoes(parseInteger(r.getExecucoes()));
                servico.setUltimaExecucao(parseLocalDateTime(r.getUltimaExecucao()));
                servico.setPercentualDesconto(parseDouble(r.getPercentualDesconto()));
                servico.setValorDesconto(parseDouble(r.getValorDesconto()));
                servico.setTipoAcresDesc(r.getTipoAcresDesc());

                servicos.add(servico);
            });

            return servicos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter serviços adicionais: ", e);
        }
    }

    @Override
    public ServicoAdicional salvar(ServicoAdicional object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ServicoAdicional> salvar(List<ServicoAdicional> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ServicoAdicional> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static Long parseLong(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        return Long.parseLong(value);
    }

    private static Integer parseInteger(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        return Integer.parseInt(value);
    }

    private static Double parseDouble(String value) {
        if (value == null || value.isBlank()) {
            return 0.0;
        }

        return Double.parseDouble(value);
    }

    private static LocalDate parseLocalDate(String value) {
        if (value == null
                || value.isBlank()
                || value.equals("0000-00-00")) {
            return null;
        }

        try {
            return LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static LocalDateTime parseLocalDateTime(String value) {
        if (value == null
                || value.isBlank()
                || value.equals("0000-00-00 00:00:00")) {
            return null;
        }

        try {
            return LocalDateTime.parse(
                    value,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
