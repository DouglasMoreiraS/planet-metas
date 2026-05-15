package br.com.planet.metas.service.report;

import br.com.planet.metas.dto.FiltroOrdemServicoDTO;
import br.com.planet.metas.dto.MetaReportData;
import br.com.planet.metas.model.Contrato;
import br.com.planet.metas.model.OrdemServico;
import br.com.planet.metas.service.ContratoService;
import br.com.planet.metas.service.OrdemServicoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MetaReportDataService {

    private final OrdemServicoService ordemServicoService;
    private final ContratoService contratoService;

    public MetaReportDataService(
            OrdemServicoService ordemServicoService,
            ContratoService contratoService
    ) {
        this.ordemServicoService = ordemServicoService;

        this.contratoService = contratoService;
    }

    public List<MetaReportData> buildReportData(LocalDate dataInicial, LocalDate dataFinal) {

        FiltroOrdemServicoDTO filtro = new FiltroOrdemServicoDTO();
        filtro.setDataInicial(dataInicial);
        filtro.setDataFinal(dataFinal);
        filtro.setAssuntoId(1L); // Instalação

        List<OrdemServico> ordensServicos = ordemServicoService.listarOrdemServicoCampo(filtro);

        List<MetaReportData> data = new ArrayList<>();

        ordensServicos.forEach(ordemServico -> {
            Contrato contrato = contratoService.buscarPorId(ordemServico.getContratoId());



            if (contrato == null) {
                return;
            }

            MetaReportData metaReportData = new MetaReportData();

            metaReportData.setOrdemServicoId((long) ordemServico.getId());

            if (ordemServico.getDataHoraFinalizacao() != null) {
                metaReportData.setDataInstalacao(
                        ordemServico.getDataHoraFinalizacao().toLocalDate()
                );
            }

            metaReportData.setIdContrato(contrato.getId());
            metaReportData.setTicket(contrato.getValorPlano());
            metaReportData.setNomePlano(contrato.getPlano());
            metaReportData.setStatus(contrato.getStatusContrato());

            if (contrato.getVendedor() != null) {
                metaReportData.setNomeVendedor(contrato.getVendedor().getNome());
                //IA: Carrega a classificacao do vendedor junto do nome para filtros no dashboard.
                metaReportData.setTipoVendedor(contrato.getVendedor().getTipo());
            }

            data.add(metaReportData);
        });

        return data;
    }

    public MetaReportData buildReportDataByContratoId(Long contratoId) {
        Contrato contrato = contratoService.buscarPorId(contratoId);

        if (contrato == null) {
            return null;
        }

        MetaReportData metaReportData = new MetaReportData();

        metaReportData.setIdContrato(contrato.getId());
        metaReportData.setTicket(contrato.getValorPlano());
        metaReportData.setNomePlano(contrato.getPlano());
        metaReportData.setStatus(contrato.getStatusContrato());

        if (contrato.getVendedor() != null) {
            metaReportData.setNomeVendedor(contrato.getVendedor().getNome());
            //IA: Mantem o endpoint de teste coerente com os dados usados pelo cache.
            metaReportData.setTipoVendedor(contrato.getVendedor().getTipo());
        }

        return metaReportData;
    }

}
