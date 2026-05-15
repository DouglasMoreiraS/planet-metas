package br.com.planet.metas.integration;

import br.com.planet.metas.response.OrdemServicoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrdemServicoIntegration extends BaseIntegration<OrdemServicoResponse> {

    private static final String URL = "/su_oss_chamado";

    public OrdemServicoIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, OrdemServicoResponse.class);
    }

    @Override
    protected String getQtype() {
        return "su_oss_chamado.id";
    }

}
