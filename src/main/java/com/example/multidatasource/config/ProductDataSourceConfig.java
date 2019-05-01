package com.example.multidatasource.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		transactionManagerRef = "productTransactionManager", 
		entityManagerFactoryRef = "productEntityManagerFactory", 
		basePackages = "com.example.multidatasource.jpa.product.repository")
public class ProductDataSourceConfig {
	
	@Bean
	@ConfigurationProperties("app.datasource.product")
	public HikariDataSource productDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(EntityManagerFactoryBuilder builder) {		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.format_sql", "true");
		return builder
				.dataSource(productDataSource())
				.packages("com.example.multidatasource.jpa.product.entity")
				.persistenceUnit("product")
				.properties(properties)
				.build();
	}
	
	@Bean
	public PlatformTransactionManager productTransactionManager(
			@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
		return new JpaTransactionManager(productEntityManagerFactory);
	}
}
