package br.com.planet.metas.service.report;

import br.com.planet.metas.dto.FiltroContratoDTO;
import br.com.planet.metas.dto.MetaReportData;
import br.com.planet.metas.dto.PontuacaoVendedorDTO;
import br.com.planet.metas.model.Contrato;
import br.com.planet.metas.service.ContratoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PontuacaoVendedorService {

    private final ContratoService contratoService;

    public PontuacaoVendedorService(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    public List<PontuacaoVendedorDTO> calcularPontuacaoPorPeriodo(
            LocalDate dataInicial,
            LocalDate dataFinal
    ) {
        FiltroContratoDTO filtro = new FiltroContratoDTO();
        filtro.setDataInicialAtivacao(dataInicial);
        filtro.setDataFinalAtivacao(dataFinal);

        List<Contrato> contratos = contratoService.listarAPI(filtro);

        Map<String, Double> pontuacaoPorVendedor = new LinkedHashMap<>();

        contratos.forEach(contrato -> {
            if (contrato.getVendedor() == null
                    || contrato.getVendedor().getNome() == null
                    || contrato.getVendedor().getNome().isBlank()) {
                return;
            }

            double ticket = contrato.getValorPlano() != null
                    ? contrato.getValorPlano()
                    : 0.0;

            double pontos = calcularPontosPorTicket(
                    ticket,
                    contrato.getVendedor().getTipo()
            );

            if (pontos <= 0.0) {
                return;
            }

            String nomeVendedor = contrato.getVendedor().getNome();

            pontuacaoPorVendedor.merge(
                    nomeVendedor,
                    pontos,
                    Double::sum
            );
        });

        return pontuacaoPorVendedor.entrySet()
                .stream()
                .map(entry -> new PontuacaoVendedorDTO(
                        entry.getKey(),
                        entry.getValue()
                ))
                .sorted(Comparator.comparing(PontuacaoVendedorDTO::getPontosTotais).reversed())
                .toList();
    }

    public List<PontuacaoVendedorDTO> calcularPontuacaoPorReportData(
            List<MetaReportData> reportData
    ) {
        Map<String, Double> pontuacaoPorVendedor = new LinkedHashMap<>();

        reportData.forEach(item -> {
            if (item.getNomeVendedor() == null || item.getNomeVendedor().isBlank()) {
                return;
            }

            double pontos = item.getPontos() != null
                    ? item.getPontos()
                    : calcularPontosPorTicket(item.getTicket(), item.getTipoVendedor());

            if (pontos <= 0.0) {
                return;
            }

            pontuacaoPorVendedor.merge(
                    item.getNomeVendedor(),
                    pontos,
                    Double::sum
            );
        });

        return pontuacaoPorVendedor.entrySet()
                .stream()
                .map(entry -> new PontuacaoVendedorDTO(
                        entry.getKey(),
                        entry.getValue()
                ))
                .sorted(Comparator.comparing(PontuacaoVendedorDTO::getPontosTotais).reversed())
                .toList();
    }

    public double calcularPontosPorTicket(Double ticket) {
        return calcularPontosPorTicket(ticket, null);
    }

    public double calcularPontosPorTicket(Double ticket, Integer tipoVendedor) {
        double valorTicket = ticket != null ? ticket : 0.0;

        //IA: Apenas tipo 1 usa a regra de vendedor externo; nulo segue interno por ser o caso mais provavel.
        if (Integer.valueOf(1).equals(tipoVendedor)) {
            return calcularPontosExterno(valorTicket);
        }

        return calcularPontosInterno(valorTicket);
    }

    private double calcularPontosInterno(double ticket) {
        if (ticket >= 60.0 && ticket <= 79.0) {
            return 0.5;
        }

        if (ticket >= 80.0 && ticket <= 89.0) {
            return 0.7;
        }

        if (ticket >= 90.0 && ticket <= 99.0) {
            return 0.9;
        }

        if (ticket >= 100.0 && ticket <= 109.0) {
            return 1.0;
        }

        if (ticket >= 110.0 && ticket <= 119.0) {
            return 1.2;
        }

        if (ticket >= 120.0 && ticket <= 124.0) {
            return 1.3;
        }

        if (ticket >= 125.0 && ticket <= 139.0) {
            return 1.4;
        }

        if (ticket >= 140.0 && ticket <= 155.0) {
            return 1.6;
        }

        if (ticket > 155.0) {
            return 1.8;
        }

        return 0.0;
    }

    private double calcularPontosExterno(double ticket) {
        if (ticket == 60.0) {
            return 0.75;
        }

        if (ticket == 70.0) {
            return 1.0;
        }

        if (ticket >= 80.0 && ticket <= 85.0) {
            return 1.5;
        }

        if (ticket >= 90.0 && ticket <= 95.0) {
            return 1.7;
        }

        if (ticket >= 100.0 && ticket <= 105.0) {
            return 1.8;
        }

        if (ticket >= 110.0 && ticket <= 115.0) {
            return 1.9;
        }

        if (ticket == 120.0) {
            return 2.0;
        }

        if (ticket >= 125.0 && ticket <= 135.0) {
            return 2.5;
        }

        if (ticket >= 140.0 && ticket <= 155.0) {
            return 2.7;
        }

        if (ticket >= 160.0 && ticket <= 175.0) {
            return 3.0;
        }

        if (ticket >= 180.0 && ticket <= 200.0) {
            return 3.3;
        }

        if (ticket > 200.0 && ticket <= 215.0) {
            return 3.5;
        }

        return 0.0;
    }
}
