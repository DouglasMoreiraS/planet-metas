package br.com.planet.metas.service;

import br.com.planet.metas.dto.FiltroColaboradorDTO;
import br.com.planet.metas.integration.ColaboradorIntegration;
import br.com.planet.metas.model.Colaborador;
import br.com.planet.metas.response.ColaboradorResponse;
import br.com.planet.metas.utils.GridParamConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColaboradorService extends BaseService<Colaborador, ColaboradorResponse> {

    ColaboradorIntegration integration;

    public ColaboradorService(ColaboradorIntegration integration) {
        this.integration = integration;
    }

    public List<Colaborador> listarAPI() {
        return parseResponse(integration.listar());
    }

    public List<Colaborador> listarAPI(FiltroColaboradorDTO dto) {
        return parseResponse(integration.listar(this.montarGridParams(dto)));
    }

    public List<Colaborador> buscarColaboradoresDeCampo() {
        
        List<Colaborador> colaboradores = new ArrayList();
        
        colaboradores.addAll(this.parseResponse(integration.listar(montarGridParams(new FiltroColaboradorDTO(11L)))));

        return colaboradores;
    }

    public Colaborador buscarColaborador(Long id) {
        return this.parseResponse(integration.listar(montarGridParams(new FiltroColaboradorDTO(id, null))))
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    protected List<Colaborador> parseResponse(ColaboradorResponse response) {

        try {

            List<Colaborador> retorno = new ArrayList<>();

            if (response == null || response.getTotal() == 0 || response.getRegistros() == null) {
                return retorno;
            }

            response.getRegistros().forEach(f -> {
                if (f.getId() != null && !f.getId().isBlank()) {
                    Colaborador c = new Colaborador(Long.parseLong(f.getId()), f.getFuncionario());
                    retorno.add(c);
                }
            });

            return retorno;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter colaboradores: ", e);
        }

    }

    private String montarGridParams(FiltroColaboradorDTO filtro) {
        List<String> params = new ArrayList<>();

        if (filtro.getId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("funcionarios.id", GridParamConstructor.EQUAL, filtro.getId().toString()));
        }

        if (filtro.getIdSetor() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("funcionarios.id_departamento", GridParamConstructor.EQUAL, filtro.getIdSetor().toString()));
        }

        return String.join(",", params);

    }

    @Override
    public Colaborador salvar(Colaborador object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Colaborador> salvar(List<Colaborador> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Colaborador> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
