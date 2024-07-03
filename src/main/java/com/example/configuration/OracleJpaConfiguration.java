package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.example.productRepository",
		entityManagerFactoryRef = "oracleBean",
		transactionManagerRef = "oracleTransctionManager"
		)
public class OracleJpaConfiguration {

	@Bean
	LocalContainerEntityManagerFactoryBean oracleBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("OracleDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder
				.dataSource(dataSource)
				.packages("com.example.productEntity")
				.build();
	}
	
	@Bean
	PlatformTransactionManager oracleTransctionManager(@Qualifier("oracleBean") LocalContainerEntityManagerFactoryBean emfb) {
		return new JpaTransactionManager(emfb.getObject());
	}
}
