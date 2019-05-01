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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		transactionManagerRef = "customerTransactionManager", 
		entityManagerFactoryRef = "customerEntityManagerFactory", 
		basePackages = "com.example.multidatasource.jpa.customer.repository")
public class CustomerDataSourceConfig {
	
	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.customer")
	public HikariDataSource customerDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(EntityManagerFactoryBuilder builder) {		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.format_sql", "true");
		return builder
				.dataSource(customerDataSource())
				.packages("com.example.multidatasource.jpa.customer.entity")
				.persistenceUnit("customer")
				.properties(properties)
				.build();
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager customerTransactionManager(
			@Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
		return new JpaTransactionManager(customerEntityManagerFactory);
	}
}
