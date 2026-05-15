package br.com.planet.metas.service;

import br.com.planet.metas.dto.FiltroReceberDTO;
import br.com.planet.metas.integration.ReceberIntegration;
import br.com.planet.metas.model.Receber;
import br.com.planet.metas.response.ReceberResponse;
import br.com.planet.metas.utils.GridParamConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceberService extends BaseService<Receber, ReceberResponse> {

    ReceberIntegration integration;

    public ReceberService(ReceberIntegration integration) {
        this.integration = integration;
    }


    public List<Receber> listarReceber(FiltroReceberDTO filtro) {
        return this.parseResponse(integration.listar(this.montarGridParams(filtro)));
    }

    private static String montarGridParams(FiltroReceberDTO filtro) {
        List<String> params = new ArrayList<>();

        if (filtro.getEmissaoInicial() != null && filtro.getEmissaoFinal() != null) {
            params.add(GridParamConstructor.DoubleGridParamConstructor("fn_areceber.data_emissao", GridParamConstructor.BE, filtro.getEmissaoInicial().toString(), filtro.getEmissaoFinal().toString()));
        }

        if (filtro.getVencimentoInicial() != null && filtro.getVencimentoFinal() != null) {
            params.add(GridParamConstructor.DoubleGridParamConstructor("fn_areceber.data_vencimento", GridParamConstructor.BE, filtro.getVencimentoInicial().toString(), filtro.getVencimentoFinal().toString()));
        }

        if (filtro.getPagamentoInicial() != null && filtro.getPagamentoFinal() != null) {
            params.add(GridParamConstructor.DoubleGridParamConstructor("fn_areceber.pagamento_data", GridParamConstructor.BE, filtro.getPagamentoInicial().toString(), filtro.getPagamentoFinal().toString()));
        }

        if (filtro.getContaId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("fn_areceber.id_conta", GridParamConstructor.EQUAL, filtro.getContaId().toString()));
        }

        if (filtro.getContratoId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("fn_areceber.id_contrato", GridParamConstructor.EQUAL, filtro.getContratoId().toString()));
        }

        return String.join(",", params);
    }

    @Override
    public Receber salvar(Receber object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Receber> salvar(List<Receber> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Receber> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Receber> listarAPI() {
        return this.parseResponse(this.integration.listar());
    }

    @Override
    protected List<Receber> parseResponse(ReceberResponse response) {

        try {
            List<Receber> receberes = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return receberes;
            }

            response.getRegistros().forEach(r -> {

                Receber receber = new Receber();

                receber.setId(parseLong(r.getId(), 0L));

                if (hasText(r.getStatus())) {
                    receber.setStatus(r.getStatus());
                }

                if (isValidDate(r.getDataEmissao())) {
                    receber.setDataEmissao(LocalDate.parse(r.getDataEmissao()));
                }

                if (isValidDate(r.getDataVencimento())) {
                    receber.setDataVencimento(LocalDate.parse(r.getDataVencimento()));
                }

                if (isValidDate(r.getPagamentoData())) {
                    receber.setDataPagamento(LocalDate.parse(r.getPagamentoData()));
                }

                receber.setValor(parseDouble(r.getValor(), 0.0));

                if (hasText(r.getPagamentoValor())) {
                    receber.setValorRecebido(parseDouble(r.getPagamentoValor(), 0.0));
                }
                
                if (hasText(r.getValorAberto())) {
                    receber.setValorAberto(parseDouble(r.getValorAberto(), 0.0));
                }


                receberes.add(receber);
            });
            return receberes;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter conta a receber: ", e);
        }

    }

    private static boolean hasText(String value) {
        return value != null && !value.isBlank();
    }

    private static boolean isValidDate(String value) {
        return hasText(value) && !value.equals("0000-00-00");
    }

    private static Long parseLong(String value, Long defaultValue) {
        if (!hasText(value)) {
            return defaultValue;
        }

        return Long.parseLong(value);
    }

    private static Double parseDouble(String value, Double defaultValue) {
        if (!hasText(value)) {
            return defaultValue;
        }

        return Double.parseDouble(value);
    }
}
