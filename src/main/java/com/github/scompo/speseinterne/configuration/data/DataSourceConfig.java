package com.github.scompo.speseinterne.configuration.data;

import java.net.URISyntaxException;

import javax.sql.DataSource;

public interface DataSourceConfig {

	DataSource dataSource() throws URISyntaxException;
}
