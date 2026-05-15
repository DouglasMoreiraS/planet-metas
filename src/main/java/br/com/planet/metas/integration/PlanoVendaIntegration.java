package br.com.planet.metas.integration;

import br.com.planet.metas.response.PlanoVendaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanoVendaIntegration extends BaseIntegration<PlanoVendaResponse> {

    private static final String URL = "/vd_contratos";

    public PlanoVendaIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, PlanoVendaResponse.class);
    }

    @Override
    protected String getQtype() {
        return "vd_contratos.id";
    }

    public PlanoVendaResponse buscarPorId(Long id) {
        String jsonBody = String.format("""
            {
              "qtype": "vd_contratos.id",
              "query": "%s",
              "oper": "=",
              "page": "1",
              "rp": "1",
              "sortname": "vd_contratos.id",
              "sortorder": "desc"
            }
        """, id);

        String responseBody = this.fazerRequisicao(jsonBody);
        return this.parseJson(responseBody, PlanoVendaResponse.class);
    }

}
