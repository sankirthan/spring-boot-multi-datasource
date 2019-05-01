package com.example.multidatasource.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

	@Autowired
	private DataSource customerDataSource;
	
	@Autowired
	@Qualifier("productDataSource")
	private DataSource productDataSource;
	
	@PostConstruct
	public void initData() {
		DatabasePopulator customerPopulator = new ResourceDatabasePopulator(new ClassPathResource("/sql/customer.sql"));
		DatabasePopulatorUtils.execute(customerPopulator, customerDataSource);
		
		DatabasePopulator productPopulator = new ResourceDatabasePopulator(new ClassPathResource("/sql/product.sql"));
		DatabasePopulatorUtils.execute(productPopulator, productDataSource);
	}
}
