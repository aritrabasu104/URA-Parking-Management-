package com.hcl.poc.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
	

	@Value("${apidetails.title}")
	private String title;
	
	@Value("${apidetails.description}")
	private String description;
	
	@Value("${apidetails.email}")
	private String email;
	
	@Value("${apidetails.url}")
	private String url;
	
	@Value("${apidetails.license}")
	private String license;
	
	@Value("${apidetails.licenseUrl}")
	private String licenseUrl;
	
	@Value("${apidetails.name}")
	private String name;
	
	@Value("${apidetails.terms-of-service}")
	private String termsOfService;
	
	@Value("${apidetails.version}")
	private String version;
	

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket gameApi() {
		return new Docket(DocumentationType.SWAGGER_2)
//				.additionalModels(typeResolver.resolve(NumGenTask.class))
				.select()
				.apis(RequestHandlerSelectors.basePackage("myapp")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(title,description,
				version, termsOfService,
				new Contact(name,url,email),
				license, licenseUrl , Collections.emptyList());

		return apiInfo;
	}
}
