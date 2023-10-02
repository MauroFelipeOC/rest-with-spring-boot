package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("RESTful API with Java 17 and Spring Boot 3")
				.version("v1")
				.description("This is a educational project")
				.contact(new Contact().url("https://github.com/MauroFelipeOC/").name("Mauro Costa").email("mauro.felipe.oc@gmail.com"))
			)
		;
	}
}
