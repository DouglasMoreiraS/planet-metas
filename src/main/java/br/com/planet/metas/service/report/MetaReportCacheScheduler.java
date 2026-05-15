package br.com.planet.metas.service.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MetaReportCacheScheduler {

    private static final Logger log = LoggerFactory.getLogger(MetaReportCacheScheduler.class);

    private final MetaReportCacheService metaReportCacheService;
    private final boolean schedulerEnabled;
    private final LocalDate dataInicial;

    public MetaReportCacheScheduler(
            MetaReportCacheService metaReportCacheService,
            @Value("${metas.cache.scheduler.enabled:true}") boolean schedulerEnabled,
            @Value("${metas.cache.scheduler.data-inicial:2026-01-01}") LocalDate dataInicial
    ) {
        this.metaReportCacheService = metaReportCacheService;
        this.schedulerEnabled = schedulerEnabled;
        this.dataInicial = dataInicial;
    }

    @Scheduled(cron = "${metas.cache.scheduler.cron:0 0 6,12 * * *}", zone = "${metas.cache.scheduler.zone:America/Sao_Paulo}")
    public void atualizarCacheAgendado() {
        if (!schedulerEnabled) {
            log.debug("[METAS] Atualizacao agendada do cache desativada.");
            return;
        }

        LocalDate dataFinal = LocalDate.now();
        long inicio = System.currentTimeMillis();

        try {
            //IA: Reaproveita a mesma regra da atualizacao manual para evitar duplicidade no cache.
            log.info("[METAS] Iniciando atualizacao agendada do cache de {} ate {}", dataInicial, dataFinal);

            int totalRegistros = metaReportCacheService.atualizarCache(dataInicial, dataFinal).size();

            log.info(
                    "[METAS] Atualizacao agendada do cache concluida com {} registros no periodo. duracaoMs={}",
                    totalRegistros,
                    System.currentTimeMillis() - inicio
            );
        } catch (Exception e) {
            log.error("[METAS] Erro ao atualizar cache de forma agendada.", e);
        }
    }
}
