package br.com.planet.metas.integration;

import br.com.planet.metas.response.AcrescimoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AcrescimoIntegration extends BaseIntegration<AcrescimoResponse> {

    private static final String URL = "/cliente_contrato_acrescimos";

    public AcrescimoIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, AcrescimoResponse.class);
    }

    @Override
    protected String getQtype() {
        return "cliente_contrato_acrescimos.id";
    }

    public AcrescimoResponse listarPorContratoId(Long contratoId) {
        String jsonBody = String.format("""
            {
              "qtype": "cliente_contrato_acrescimos.id_contrato",
              "query": "%s",
              "oper": "=",
              "page": "1",
              "rp": "1000",
              "sortname": "cliente_contrato_acrescimos.id",
              "sortorder": "desc"
            }
        """, contratoId);

        String responseBody = this.fazerRequisicao(jsonBody);
        return this.parseJson(responseBody, AcrescimoResponse.class);
    }

}
