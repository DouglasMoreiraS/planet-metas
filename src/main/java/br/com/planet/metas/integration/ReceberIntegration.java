package br.com.planet.metas.integration;

import br.com.planet.metas.response.ReceberResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReceberIntegration extends BaseIntegration<ReceberResponse>{
    
    private static final String URL = "/fn_areceber";

    public ReceberIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, ReceberResponse.class);
    }

    @Override
    protected String getQtype() {
        return "fn_areceber.id";
    }

}
