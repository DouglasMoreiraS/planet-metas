package br.com.planet.metas.repository.cache;

import br.com.planet.metas.model.MetaReportCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MetaReportCacheRepository extends JpaRepository<MetaReportCache, Long> {

    List<MetaReportCache> findByDataInstalacaoBetweenOrderByDataInstalacaoAscContratoIdAsc(
            LocalDate dataInicial,
            LocalDate dataFinal
    );

    Optional<MetaReportCache> findFirstByContratoIdAndOrdemServicoId(
            Long contratoId,
            Long ordemServicoId
    );

    Optional<MetaReportCache> findFirstByContratoIdOrderByAtualizadoEmDesc(Long contratoId);

    @Query("select max(cache.atualizadoEm) from MetaReportCache cache")
    Optional<LocalDateTime> findUltimaAtualizacao();
}
