package br.com.planet.metas.integration;

import br.com.planet.metas.response.ContratoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContratoIntegration extends BaseIntegration<ContratoResponse>{

    private static final String URL = "/cliente_contrato";

    public ContratoIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL,ContratoResponse.class);
    }

    @Override
    protected String getQtype(){
        return "cliente_contrato.id";
    }


}
