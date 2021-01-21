package com.hcl.poc.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

	@Value("${ura-db-url-dev}")
	private String dbUrl;

	@Value("${ura-db-username-dev}")
	private String dbUsername;

	@Value("${ura-db-password-dev}")
	private String dbPassword;

	@Value("${ura-db-driverClassName-dev}")
	private String dbDriverClass;

	@Lazy
	@Autowired
	ObjectMapper mapper;

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(dbDriverClass);
		dataSourceBuilder.url(dbUrl);
		dataSourceBuilder.username(dbUsername);
		dataSourceBuilder.password(dbPassword);
		return dataSourceBuilder.build();
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
