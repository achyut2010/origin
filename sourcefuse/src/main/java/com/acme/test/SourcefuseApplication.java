package com.acme.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class SourcefuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourcefuseApplication.class, args);
	}
	
	@Bean
	public JsonMapper jsonMapperBuild() {
		return JsonMapper.builder()
				.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.serializationInclusion(JsonInclude.Include.NON_NULL)
				.addModule(new JavaTimeModule())
				.build();
	}

}
