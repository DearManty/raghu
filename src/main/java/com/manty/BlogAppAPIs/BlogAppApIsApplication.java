package com.manty.BlogAppAPIs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.manty.BlogAppAPIs.Repository.UserRepository;

@SpringBootApplication

public class BlogAppApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApIsApplication.class, args);
	}
	@Bean
public ModelMapper modelmapper() {
	return new ModelMapper();
	
}
}
