package br.com.planet.metas.integration;

import br.com.planet.metas.response.ServicoAdicionalResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicoAdicionalIntegration extends BaseIntegration<ServicoAdicionalResponse> {

    private static final String URL = "/cliente_contrato_servicos";

    public ServicoAdicionalIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, ServicoAdicionalResponse.class);
    }

    @Override
    protected String getQtype() {
        return "cliente_contrato_servicos.id";
    }

    public ServicoAdicionalResponse listarPorContratoId(Long contratoId) {
        String jsonBody = String.format("""
            {
              "qtype": "cliente_contrato_servicos.tipo_acres_desc",
              "query": "A",
              "oper": "=",
              "page": "1",
              "rp": "1000",
              "sortname": "cliente_contrato_servicos.id",
              "sortorder": "desc",
              "grid_param": "[{\\"TB\\":\\"cliente_contrato_servicos.id_contrato\\",\\"OP\\":\\"=\\",\\"P\\":\\"%s\\"}]"
            }
        """, contratoId);

        String responseBody = this.fazerRequisicao(jsonBody);
        return this.parseJson(responseBody, ServicoAdicionalResponse.class);
    }
}
