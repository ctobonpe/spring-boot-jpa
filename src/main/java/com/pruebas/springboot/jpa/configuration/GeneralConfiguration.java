package com.pruebas.springboot.jpa.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:connection.properties")
public class GeneralConfiguration {
	
	@Value("${jdbc.url}")
	private String JDBCUrl;
	
	@Value("${driver}")
	private String driver;
	
	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String password;
	
	@Bean	
	public DataSource datasource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(JDBCUrl);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(password);
		
		
		return dataSourceBuilder.build();
		
	}

}
