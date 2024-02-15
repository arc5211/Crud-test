package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class DevCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevCrudApplication.class, args);
		System.out.println("----started spring project----");
	}
	@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
