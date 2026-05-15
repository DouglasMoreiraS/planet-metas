package br.com.planet.metas.integration;

import br.com.planet.metas.response.ColaboradorResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ColaboradorIntegration extends BaseIntegration<ColaboradorResponse> {
    private static final String URL = "/funcionarios";

    public ColaboradorIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, ColaboradorResponse.class);
    }

    @Override
    protected String getQtype() {
        return "funcionarios.id";
    }
}