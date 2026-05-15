package br.com.planet.metas.service.report;

import br.com.planet.metas.dto.MetaReportData;
import br.com.planet.metas.model.MetaReportCache;
import br.com.planet.metas.repository.cache.MetaReportCacheRepository;
import br.com.planet.metas.service.VendedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MetaReportCacheService {

    private static final Logger log = LoggerFactory.getLogger(MetaReportCacheService.class);

    private final MetaReportCacheRepository repository;
    private final MetaReportDataService metaReportDataService;
    private final PontuacaoVendedorService pontuacaoVendedorService;
    private final VendedorService vendedorService;

    public MetaReportCacheService(
            MetaReportCacheRepository repository,
            MetaReportDataService metaReportDataService,
            PontuacaoVendedorService pontuacaoVendedorService,
            VendedorService vendedorService
    ) {
        this.repository = repository;
        this.metaReportDataService = metaReportDataService;
        this.pontuacaoVendedorService = pontuacaoVendedorService;
        this.vendedorService = vendedorService;
    }

    public List<MetaReportData> atualizarCache(LocalDate dataInicial, LocalDate dataFinal) {
        long inicio = System.currentTimeMillis();

        log.info("[METAS] Iniciando atualizacao do cache de {} ate {}", dataInicial, dataFinal);

        //IA: Forca nova leitura dos vendedores para refletir ajustes recentes de interno/externo.
        vendedorService.limparCache();

        List<MetaReportData> reportData = metaReportDataService.buildReportData(
                dataInicial,
                dataFinal
        );

        List<MetaReportCache> cache = reportData.stream()
                .filter(item -> item.getIdContrato() != null)
                .map(this::toCache)
                .toList();

        repository.saveAll(cache);

        List<MetaReportData> relatorioAtualizado = buscarRelatorio(dataInicial, dataFinal);

        //IA: Registra volume e duracao para diagnosticar lentidao na IXC/cache.
        log.info(
                "[METAS] Cache atualizado de {} ate {}. Recebidos={}, salvos={}, retornados={}, duracaoMs={}",
                dataInicial,
                dataFinal,
                reportData.size(),
                cache.size(),
                relatorioAtualizado.size(),
                System.currentTimeMillis() - inicio
        );

        return relatorioAtualizado;
    }

    public List<MetaReportData> buscarRelatorio(LocalDate dataInicial, LocalDate dataFinal) {
        return repository.findByDataInstalacaoBetweenOrderByDataInstalacaoAscContratoIdAsc(
                        dataInicial,
                        dataFinal
                )
                .stream()
                .map(this::toReportData)
                .toList();
    }

    public List<MetaReportData> buscarRelatorio(LocalDate dataInicial, LocalDate dataFinal, Integer tipoVendedor) {
        //IA: Filtra depois da leitura para reaproveitar o mesmo cache e manter compatibilidade com registros antigos.
        return buscarRelatorio(dataInicial, dataFinal)
                .stream()
                .filter(item -> tipoVendedor == null || tipoVendedor.equals(item.getTipoVendedor()))
                .toList();
    }

    public LocalDateTime buscarUltimaAtualizacao() {
        return repository.findUltimaAtualizacao()
                .orElse(null);
    }

    private MetaReportCache toCache(MetaReportData item) {
        MetaReportCache cache = buscarCacheExistente(item);

        cache.setContratoId(item.getIdContrato());
        cache.setOrdemServicoId(item.getOrdemServicoId());
        cache.setDataInstalacao(item.getDataInstalacao());
        cache.setNomeCliente(item.getNomeCliente());
        cache.setNomeVendedor(item.getNomeVendedor());
        cache.setTipoVendedor(item.getTipoVendedor());
        cache.setNomePlano(item.getNomePlano());
        cache.setTicket(item.getTicket());
        //IA: Persiste os pontos ja considerando a regra por tipo de vendedor.
        cache.setPontos(pontuacaoVendedorService.calcularPontosPorTicket(
                item.getTicket(),
                item.getTipoVendedor()
        ));
        cache.setStatus(item.getStatus());

        return cache;
    }

    private MetaReportCache buscarCacheExistente(MetaReportData item) {
        if (item.getOrdemServicoId() != null) {
            return repository.findFirstByContratoIdAndOrdemServicoId(
                            item.getIdContrato(),
                            item.getOrdemServicoId()
                    )
                    .orElseGet(MetaReportCache::new);
        }

        return repository.findFirstByContratoIdOrderByAtualizadoEmDesc(item.getIdContrato())
                .orElseGet(MetaReportCache::new);
    }

    private MetaReportData toReportData(MetaReportCache cache) {
        MetaReportData data = new MetaReportData();

        data.setOrdemServicoId(cache.getOrdemServicoId());
        data.setDataInstalacao(cache.getDataInstalacao());
        data.setIdContrato(cache.getContratoId());
        data.setNomeCliente(cache.getNomeCliente());
        data.setNomePlano(cache.getNomePlano());
        data.setNomeVendedor(cache.getNomeVendedor());
        data.setTipoVendedor(cache.getTipoVendedor());
        data.setTicket(cache.getTicket());
        data.setPontos(cache.getPontos());
        data.setStatus(cache.getStatus());

        return data;
    }
}
