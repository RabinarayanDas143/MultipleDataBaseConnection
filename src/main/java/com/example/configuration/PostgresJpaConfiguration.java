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
		basePackages = "com.example.orderRepository",
		entityManagerFactoryRef = "postgresBean",
		transactionManagerRef = "postgresTransctionManager"
		)
public class PostgresJpaConfiguration {

	@Bean
	LocalContainerEntityManagerFactoryBean postgresBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("PostgresSqlDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder
				.dataSource(dataSource)
				.packages("com.example.orderEntity")
				.build();
	}
	
	@Bean
	PlatformTransactionManager postgresTransctionManager(@Qualifier("postgresBean") LocalContainerEntityManagerFactoryBean emfb) {
		return new JpaTransactionManager(emfb.getObject());
	}
}
