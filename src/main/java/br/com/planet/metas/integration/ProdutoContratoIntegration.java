package br.com.planet.metas.integration;

import br.com.planet.metas.response.ProdutoContratoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProdutoContratoIntegration extends BaseIntegration<ProdutoContratoResponse> {

    private static final String URL = "/vd_contratos_produtos";

    public ProdutoContratoIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, ProdutoContratoResponse.class);
    }

    @Override
    protected String getQtype() {
        return "vd_contratos_produtos.id";
    }

    public ProdutoContratoResponse listarPorContratoId(Long contratoId) {
        String jsonBody = String.format("""
            {
              "qtype": "vd_contratos_produtos.id_contrato",
              "query": "%s",
              "oper": "=",
              "page": "1",
              "rp": "1000",
              "sortname": "vd_contratos_produtos.id",
              "sortorder": "desc"
            }
        """, contratoId);

        String responseBody = this.fazerRequisicao(jsonBody);
        return this.parseJson(responseBody, ProdutoContratoResponse.class);
    }

}
