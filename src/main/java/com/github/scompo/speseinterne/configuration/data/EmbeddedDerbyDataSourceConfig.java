package com.github.scompo.speseinterne.configuration.data;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.github.scompo.speseinterne.configuration.Development;

@Development
@Configuration
public class EmbeddedDerbyDataSourceConfig implements DataSourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(EmbeddedDerbyDataSourceConfig.class);

	@Bean
	@Override
	public DataSource dataSource() {

		EmbeddedDatabase embeddedDataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).build();

		logger.info("Using embedded datasource: {}", embeddedDataSource);

		return embeddedDataSource;
	}
}
