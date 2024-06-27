package com.abcbank.customer.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customerOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("ABC Bank REST APIs")
						.version("1.0")
						.description("sample REST apis")
						);
	}
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public")
				.pathsToMatch("/api/**")
				.build();
	}
}
