package br.com.planet.metas;

import br.com.planet.metas.model.MetaReportCache;
import br.com.planet.metas.repository.cache.MetaReportCacheRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan(basePackageClasses = MetaReportCache.class)
@EnableJpaRepositories(basePackageClasses = MetaReportCacheRepository.class)
@EnableScheduling
public class MetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetasApplication.class, args);
	}

}
