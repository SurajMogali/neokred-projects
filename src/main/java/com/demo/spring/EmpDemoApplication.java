package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableCaching
public class EmpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDemoApplication.class, args);
	}
	
	@Bean
	public OpenAPI openApiDoc() {
		return new OpenAPI().info(new Info().description("Mock project on Employee Project")
				.license(new License().name("Free for All")).title("Mock Project Document").version("1.0.0-BETA"));
	}
	
	

}
