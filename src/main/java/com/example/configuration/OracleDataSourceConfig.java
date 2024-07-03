package com.example.configuration;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class OracleDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.oracle")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	@Primary
	@Bean
	@Qualifier("OracleDataSource")
	public DataSource oracleDataSource() {
//		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
//		dataSource.setUsername(dataSourceProperties().getUsername());
//		dataSource.setPassword(dataSourceProperties().getPassword());
//		dataSource.setUrl(dataSourceProperties().getUrl());
//		dataSource.setDriverClassName(dataSourceProperties().getDriverClassName());
		
		return dataSourceProperties().initializeDataSourceBuilder().build();
	}
}
