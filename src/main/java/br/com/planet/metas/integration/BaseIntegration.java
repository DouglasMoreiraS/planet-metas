package br.com.planet.metas.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class BaseIntegration<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseIntegration.class);

    protected final RestTemplate restTemplate;
    protected final String endpoint;
    protected final Class<T> type;

    @Value("${ixc.base-url:https://central.planetinternetprovedor.com.br/webservice/v1/}")
    private String baseUrl;

    @Value("${ixc.auth}")
    private String authStr;

    @Value("${ixc.test-url:https://central.planetinternetprovedor.com.br/webservice/v1/usuarios}")
    private String testUrl;

    protected static final String HEADER_NAME = "ixcsoft";
    protected static final String HEADER_TYPE = "listar";

    public BaseIntegration(RestTemplate restTemplate, String endpoint, Class<T> type) {
        this.restTemplate = restTemplate;
        this.endpoint = endpoint;
        this.type = type;
    }

    protected String fazerRequisicao(String jsonBody) {
        long inicio = System.currentTimeMillis();

        try {
            HttpEntity<String> request = new HttpEntity<>(jsonBody, createHeaders());

            ResponseEntity<String> response = restTemplate.exchange(
                    baseUrl + endpoint,
                    HttpMethod.POST,
                    request,
                    String.class
            );

            long fim = System.currentTimeMillis();
            log.info("[IXC] {} executado em {}ms", endpoint, fim - inicio);

            return response.getBody();
        } catch (Exception e) {
            long fim = System.currentTimeMillis();
            log.error("[IXC] {} falhou após {}ms", endpoint, fim - inicio);

            throw new RuntimeException("Erro ao fazer requisicao API IXCSoft: ", e);
        }
    }

    public ResponseEntity<String> testarApi() {
        HttpEntity<String> request = new HttpEntity<>(createHeaders());

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    testUrl,
                    HttpMethod.HEAD,
                    request,
                    String.class
            );
            return ResponseEntity.ok("API externa OK! Status: " + response.getStatusCode());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Falha ao testar API externa: " + e.getMessage());
        }
    }

    protected String montarJsonBody(String gridParams) {
        return String.format("""
            {
              "qtype": "%s",
              "query": "1",
              "oper": ">=",
              "page": "1",
              "rp": "50000",
              "sortname": "%s",
              "sortorder": "desc",
              "grid_param": "[%s]"
            }
        """, getQtype(), getQtype(), gridParams);
    }

    protected abstract String getQtype();

    public T listar() {
        String responseBody = fazerRequisicao(montarJsonBody(""));
        return parseJson(responseBody, type);
    }

    public T listar(String gridParam) {
        String responseBody = fazerRequisicao(montarJsonBody(gridParam));
        return parseJson(responseBody, type);
    }

    protected <R> R parseJson(String responseBody, Class<R> clazz) {
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.readValue(responseBody, clazz);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Erro ao converter resposta da API IXCSoft: ", ex);
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authorization", "Basic " + encodeAuth());
        headers.set(HEADER_NAME, HEADER_TYPE);
        return headers;
    }

    private String encodeAuth() {
        return Base64.getEncoder().encodeToString(authStr.getBytes(StandardCharsets.UTF_8));
    }
}
