package com.cts;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages= {"com.cts"})
@EnableEurekaClient
@EnableSwagger2
public class VendorManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(VendorManagementApplication.class, args);
	}
	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/vendor/**"))
				.build()
				
				.apiInfo(new ApiInfo("Vendor API Documentation",
						"A Sample API for Vendors",
						"1.0.0",
						"Shopping is Fun",
						new Contact("Nikhila", "www.nikhilacorporation.com", "nikhiladamaraju30@gmail.com"), 
						"Standard API License",
						"www.nikhila.com",
						Collections.emptyList()));
				
				
	}
	
	@Bean
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
