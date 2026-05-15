package br.com.planet.metas.service;

import br.com.planet.metas.integration.VendedorIntegration;
import br.com.planet.metas.model.Vendedor;
import br.com.planet.metas.response.VendedorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorService extends BaseService<Vendedor, VendedorResponse> {


    @Autowired
    VendedorIntegration integration;

    private List<Vendedor> vendedoresCache;


    @Override
    public List<Vendedor> listar() {
        return null;
    }


    @Override
    public Vendedor salvar(Vendedor object) {
        return null;
    }

    @Override
    public List<Vendedor> salvar(List<Vendedor> list) {
        return null;
    }

    @Override
    public List<Vendedor> listarAPI() {
        if (vendedoresCache == null) {
            vendedoresCache = parseResponse(integration.listar());
        }

        return vendedoresCache;
    }

    public void limparCache() {
        vendedoresCache = null;
    }

    @Override
    public List<Vendedor> parseResponse(VendedorResponse response) {

        try {
            List<Vendedor> retorno = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return retorno;
            }

            response.getRegistros().forEach(v -> {

                Vendedor vv = new Vendedor();

                if (v.getId() != null && !v.getId().isBlank()) {
                    vv.setId(Long.parseLong(v.getId()));
                }
                vv.setNome(v.getNome());

                try {
                    vv.setTipo(Integer.parseInt(v.getPipeIdUsuario()));
                } catch (NumberFormatException ex) {
                    vv.setTipo(0);
                }
                retorno.add(vv);

            });

            return retorno;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter Vendedor: ", e);
        }

    }
}
