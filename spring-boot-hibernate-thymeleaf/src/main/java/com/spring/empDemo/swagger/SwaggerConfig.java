package com.spring.empDemo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		System.out.println("\n" + new Object() {
		}.getClass().getEnclosingMethod().getName() + " method called !!!" + "\n");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.howtodoinjava.demo.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("\"Spring Boot REST API for Manage Employee Data\"").license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org").contact(new Contact("Nick Patel",
						"http://localhost:8080/swagger-ui.html#/employee-mvc-controller", "pd@narola.email"))
				.build();
	}
}
