package com.github.scompo.speseinterne.configuration.data;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.scompo.speseinterne.configuration.Production;

@Production
@Configuration
public class PostgresHerokuDatasourceConfig implements DataSourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(PostgresHerokuDatasourceConfig.class);

	@Bean
	@Override
	public DataSource dataSource() throws URISyntaxException {
		
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        logger.info("running production database: {}", basicDataSource);
        
        return basicDataSource;
	}

}
