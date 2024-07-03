package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PostgresDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.pg")
	public DataSourceProperties postGresDataSourceProperties() {
		return new DataSourceProperties();
	}

	
	@Bean
	@Qualifier("PostgresSqlDataSource")
	public DataSource postGresSqlDataSource() {
		return postGresDataSourceProperties().initializeDataSourceBuilder().build();
	}
}
