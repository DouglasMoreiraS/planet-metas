package br.com.planet.metas.integration;

import br.com.planet.metas.response.VendedorResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VendedorIntegration extends BaseIntegration<VendedorResponse> {

    private static final String URL = "/vendedor";

    public VendedorIntegration(RestTemplate restTemplate) {
        super(restTemplate, URL, VendedorResponse.class);
    }

    @Override
    protected String getQtype() {
        return "vendedor.id";
    }

}
