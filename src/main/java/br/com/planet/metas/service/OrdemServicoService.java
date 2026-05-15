package br.com.planet.metas.service;

import br.com.planet.metas.dto.FiltroOrdemServicoDTO;
import br.com.planet.metas.integration.OrdemServicoIntegration;
import br.com.planet.metas.model.Colaborador;
import br.com.planet.metas.model.OrdemServico;
import br.com.planet.metas.response.OrdemServicoResponse;
import br.com.planet.metas.utils.GridParamConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrdemServicoService extends BaseService<OrdemServico, OrdemServicoResponse> {

    ColaboradorService colaboradorService;
    //AssuntoService assuntoService;

    OrdemServicoIntegration integration;

    public OrdemServicoService(ColaboradorService colaboradorService, OrdemServicoIntegration integration) {
        this.colaboradorService = colaboradorService;
        this.integration = integration;
    }

    public List<OrdemServico> listarAPI(FiltroOrdemServicoDTO dto) {
        return this.parseResponse(integration.listar(this.montarGridParams(dto)));
    }

    public List<OrdemServico> listarOrdemServicoCampo(FiltroOrdemServicoDTO dto) {
        dto.setSetorId(11L);

        List<OrdemServico> ordens = listarAPI(dto);

        List<Long> colabIds = colaboradorService.buscarColaboradoresDeCampo()
                .stream()
                .map(colaborador -> colaborador.getId())
                .collect(Collectors.toList());

        Set<Long> assuntosEstoque = Set.of(115L, 116L, 258L);

        List<OrdemServico> retorno = new ArrayList<>();

        ordens.forEach(os -> {
            if (os.getColaborador() == null || os.getColaborador().getId() == null) {
                return;
            }

            if (!colabIds.contains(os.getColaborador().getId())) {
                return;
            }

            if (assuntosEstoque.contains(os.getAssuntoId())) {
                return;
            }

            retorno.add(os);
        });
        return retorno;
    }


    private static String montarGridParams(FiltroOrdemServicoDTO filtro) {

            List<String> params = new ArrayList();

        if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String filtroDataInicial = filtro.getDataInicial().atStartOfDay().format(formatter);
            String filtroDataFinal = filtro.getDataFinal().atTime(23, 59, 59).format(formatter);

            params.add(GridParamConstructor.DoubleGridParamConstructor("su_oss_chamado.data_fechamento",
                    GridParamConstructor.BE,
                    filtroDataInicial,
                    filtroDataFinal));
        }

        if (filtro.getAssuntoId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("su_oss_chamado.id_assunto",
                    GridParamConstructor.EQUAL,
                    filtro.getAssuntoId().toString()));
        }

        if (filtro.getColaboradorId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("su_oss_chamado.id_tecnico",
                    GridParamConstructor.EQUAL,
                    filtro.getColaboradorId().toString()));
        }

        if (filtro.getStatus() != null && !filtro.getStatus().isBlank()) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("su_oss_chamado.status",
                    GridParamConstructor.EQUAL,
                    filtro.getStatus()));
        }

        if (filtro.getSetorId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("su_oss_chamado.setor",
                    GridParamConstructor.EQUAL,
                    filtro.getSetorId().toString()));
        }
        
        if (filtro.getAtendimentoId()!= null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor("su_oss_chamado.id_ticket",
                    GridParamConstructor.EQUAL,
                    filtro.getAtendimentoId().toString()));
        }
        
         if (filtro.getDataAgendamentoInicial()!= null && filtro.getDataAgendamentoFinal() != null) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String filtroDataInicial = filtro.getDataAgendamentoInicial().atStartOfDay().format(formatter);
            String filtroDataFinal = filtro.getDataAgendamentoFinal().atTime(23, 59, 59).format(formatter);

            params.add(GridParamConstructor.DoubleGridParamConstructor("su_oss_chamado.data_agenda",
                    GridParamConstructor.BE,
                    filtroDataInicial,
                    filtroDataFinal));
        }
        
        return String.join(",", params);
    }

    @Override
    protected List<OrdemServico> parseResponse(OrdemServicoResponse response) {
        List<OrdemServico> retorno = new ArrayList();
        try {

            if (response == null || response.getTotal() == 0 || response.getRegistros() == null) {
                return retorno;
            }

        //    List<Colaborador> colaboradores = colaboradorService.listarAPI();
        //    List<Assunto> assuntos = assuntoService.listar();

                response.getRegistros().forEach(os -> {

                    OrdemServico oss = new OrdemServico();
                    oss.setId(parseInteger(os.getId(), 0));
                    oss.setAtendimentoId(parseLong(os.getIdTicket(), 0L));

                    if (os.getIdTecnico() != null && !os.getIdTecnico().isBlank()) {
                        oss.setColaborador(new Colaborador(Long.parseLong(os.getIdTecnico()), null));
                    }

                    if (os.getIdAssunto() != null && !os.getIdAssunto().isBlank()) {
                        oss.setAssuntoId(Long.parseLong(os.getIdAssunto()));
                    }

                    oss.setBairro(os.getBairro());
                    oss.setCondominio(os.getIdCondominio());
                    oss.setContratoId(parseLong(os.getIdContratoKit(), 0L));
                
                    if (isValidDateTime(os.getDataFechamento())) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        oss.setDataHoraFinalizacao(LocalDateTime.parse(os.getDataFechamento(), formatter));
                    }
                
                if (isValidDateTime(os.getDataAgenda())) {
                    oss.setDataHoraAgendamento(LocalDateTime.parse(os.getDataAgenda(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
                
                retorno.add(oss);
            });
            return retorno;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter O.S: ", e);
        }
    }

    @Override
    public OrdemServico salvar(OrdemServico object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdemServico> salvar(List<OrdemServico> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdemServico> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdemServico> listarAPI() {
        return this.parseResponse(integration.listar());
    }

    private static boolean isValidDateTime(String value) {
        return value != null && !value.isBlank() && !value.equals("0000-00-00 00:00:00");
    }

    private static Long parseLong(String value, Long defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return Long.parseLong(value);
    }

    private static Integer parseInteger(String value, Integer defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return Integer.parseInt(value);
    }

}
