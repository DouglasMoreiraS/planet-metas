package br.com.planet.metas.integration;

import br.com.planet.metas.response.DescontoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DescontoIntegration extends BaseIntegration<DescontoResponse> {

    private static final String URL = "/cliente_contrato_descontos";

    public DescontoIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, DescontoResponse.class);
    }

    @Override
    protected String getQtype() {
        return "cliente_contrato_descontos.id";
    }

    public DescontoResponse listarPorContratoId(Long contratoId) {
        String jsonBody = String.format("""
            {
              "qtype": "cliente_contrato_descontos.id_contrato",
              "query": "%s",
              "oper": "=",
              "page": "1",
              "rp": "1000",
              "sortname": "cliente_contrato_descontos.id",
              "sortorder": "desc"
            }
        """, contratoId);

        String responseBody = this.fazerRequisicao(jsonBody);
        return this.parseJson(responseBody, DescontoResponse.class);
    }

}
