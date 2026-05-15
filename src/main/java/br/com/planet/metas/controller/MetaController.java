package br.com.planet.metas.controller;

import br.com.planet.metas.dto.MetaReportData;
import br.com.planet.metas.dto.MetasDashboardDTO;
import br.com.planet.metas.dto.PontuacaoVendedorDTO;
import br.com.planet.metas.service.report.MetaReportCacheService;
import br.com.planet.metas.service.report.MetaReportDataService;
import br.com.planet.metas.service.report.MetaReportService;
import br.com.planet.metas.service.report.PontuacaoVendedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    private static final Logger log = LoggerFactory.getLogger(MetaController.class);
    private static final LocalDate DATA_MINIMA_PERMITIDA = LocalDate.of(2026, 1, 1);

    private final MetaReportDataService metaReportDataService;
    private final MetaReportService metaReportService;
    private final PontuacaoVendedorService pontuacaoVendedorService;
    private final MetaReportCacheService metaReportCacheService;

    public MetaController(
            MetaReportDataService metaReportDataService,
            MetaReportService metaReportService,
            PontuacaoVendedorService pontuacaoVendedorService,
            MetaReportCacheService metaReportCacheService
    ) {
        this.metaReportDataService = metaReportDataService;
        this.metaReportService = metaReportService;
        this.pontuacaoVendedorService = pontuacaoVendedorService;
        this.metaReportCacheService = metaReportCacheService;
    }

    @GetMapping("/dados-relatorio")
    public ResponseEntity<List<MetaReportData>> buscarDadosRelatorio(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataInicial,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataFinal,

            @RequestParam(required = false)
            Integer tipoVendedor
    ) {
        long inicio = System.currentTimeMillis();

        validarPeriodoPermitido(dataInicial, dataFinal);
        validarTipoVendedor(tipoVendedor);

        log.info(
                "[METAS] Buscando dados do relatorio de {} ate {} com tipoVendedor={}",
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        List<MetaReportData> reportData = metaReportCacheService.buscarRelatorio(
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        log.info(
                "[METAS] Dados do relatorio carregados. registros={}, duracaoMs={}",
                reportData.size(),
                System.currentTimeMillis() - inicio
        );

        return ResponseEntity.ok(reportData);
    }

    @GetMapping("/relatorio")
    public ResponseEntity<byte[]> gerarRelatorio(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataInicial,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataFinal,

            @RequestParam(required = false)
            Integer tipoVendedor
    ) {
        long inicio = System.currentTimeMillis();

        validarPeriodoPermitido(dataInicial, dataFinal);
        validarTipoVendedor(tipoVendedor);

        List<MetaReportData> reportData = metaReportCacheService.buscarRelatorio(
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        byte[] spreadsheet = metaReportService.generateSpreadsheet(reportData);

        //IA: Loga volume exportado sem expor dados sensiveis de clientes.
        log.info(
                "[METAS] Relatorio Excel gerado de {} ate {} com tipoVendedor={}. registros={}, tamanhoBytes={}, duracaoMs={}",
                dataInicial,
                dataFinal,
                tipoVendedor,
                reportData.size(),
                spreadsheet.length,
                System.currentTimeMillis() - inicio
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                )
        );
        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename("metas.xlsx")
                        .build()
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(spreadsheet);
    }

    @GetMapping("/teste/contrato/{idContrato}")
    public ResponseEntity<MetaReportData> buscarMetaReportDataPorContrato(
            @PathVariable Long idContrato
    ) {
        MetaReportData metaReportData = metaReportDataService.buildReportDataByContratoId(idContrato);

        if (metaReportData == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(metaReportData);
    }

    @GetMapping("/pontuacao-vendedores")
    public ResponseEntity<List<PontuacaoVendedorDTO>> buscarPontuacaoVendedores(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataInicial,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataFinal,

            @RequestParam(required = false)
            Integer tipoVendedor
    ) {
        long inicio = System.currentTimeMillis();

        validarPeriodoPermitido(dataInicial, dataFinal);
        validarTipoVendedor(tipoVendedor);

        List<MetaReportData> reportData = metaReportCacheService.buscarRelatorio(
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        List<PontuacaoVendedorDTO> pontuacoes =
                pontuacaoVendedorService.calcularPontuacaoPorReportData(reportData);

        log.info(
                "[METAS] Pontuacao de vendedores carregada de {} ate {} com tipoVendedor={}. vendedores={}, duracaoMs={}",
                dataInicial,
                dataFinal,
                tipoVendedor,
                pontuacoes.size(),
                System.currentTimeMillis() - inicio
        );

        return ResponseEntity.ok(pontuacoes);
    }

    @PostMapping("/cache/atualizar")
    public ResponseEntity<MetasDashboardDTO> atualizarCache(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataInicial,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataFinal,

            @RequestParam(required = false)
            Integer tipoVendedor
    ) {
        long inicio = System.currentTimeMillis();

        validarPeriodoPermitido(dataInicial, dataFinal);
        validarTipoVendedor(tipoVendedor);

        log.info(
                "[METAS] Atualizando cache via endpoint de {} ate {} com tipoVendedor={}",
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        metaReportCacheService.atualizarCache(
                dataInicial,
                dataFinal
        );

        List<MetaReportData> reportData = metaReportCacheService.buscarRelatorio(
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        List<PontuacaoVendedorDTO> pontuacoes =
                pontuacaoVendedorService.calcularPontuacaoPorReportData(reportData);

        log.info(
                "[METAS] Atualizacao via endpoint concluida. registros={}, vendedores={}, duracaoMs={}",
                reportData.size(),
                pontuacoes.size(),
                System.currentTimeMillis() - inicio
        );

        return ResponseEntity.ok(new MetasDashboardDTO(
                reportData,
                pontuacoes,
                metaReportCacheService.buscarUltimaAtualizacao()
        ));
    }

    @GetMapping("/cache/ultima-atualizacao")
    public ResponseEntity<LocalDateTime> buscarUltimaAtualizacaoCache() {
        //IA: Permite alimentar a tela ao abrir sem buscar todo o dashboard.
        return ResponseEntity.ok(metaReportCacheService.buscarUltimaAtualizacao());
    }

    @GetMapping("/dashboard")
    public ResponseEntity<MetasDashboardDTO> buscarDashboard(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataInicial,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataFinal,

            @RequestParam(required = false)
            Integer tipoVendedor
    ) {
        long inicio = System.currentTimeMillis();

        validarPeriodoPermitido(dataInicial, dataFinal);
        validarTipoVendedor(tipoVendedor);

        List<MetaReportData> reportData = metaReportCacheService.buscarRelatorio(
                dataInicial,
                dataFinal,
                tipoVendedor
        );

        List<PontuacaoVendedorDTO> pontuacoes =
                pontuacaoVendedorService.calcularPontuacaoPorReportData(reportData);

        log.info(
                "[METAS] Dashboard carregado de {} ate {} com tipoVendedor={}. registros={}, vendedores={}, duracaoMs={}",
                dataInicial,
                dataFinal,
                tipoVendedor,
                reportData.size(),
                pontuacoes.size(),
                System.currentTimeMillis() - inicio
        );

        return ResponseEntity.ok(new MetasDashboardDTO(
                reportData,
                pontuacoes,
                metaReportCacheService.buscarUltimaAtualizacao()
        ));
    }

    private void validarPeriodoPermitido(LocalDate dataInicial, LocalDate dataFinal) {
        if (dataInicial == null || dataFinal == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Informe a data inicial e a data final."
            );
        }

        if (dataInicial.isBefore(DATA_MINIMA_PERMITIDA)
                || dataFinal.isBefore(DATA_MINIMA_PERMITIDA)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Periodo permitido apenas a partir de 2026-01-01."
            );
        }
    }

    private void validarTipoVendedor(Integer tipoVendedor) {
        //IA: O filtro usa a convencao do cadastro: 0 interno e 1 externo.
        if (tipoVendedor != null && tipoVendedor != 0 && tipoVendedor != 1) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Tipo de vendedor invalido. Use 0 para interno ou 1 para externo."
            );
        }
    }
}
