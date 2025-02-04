package com.example.JFS.Mini.Project_1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot SWAGGER ",
				description = "SWAGGER TESTING",
				version = "1.0.0",
				contact = @Contact(
						name = "Shankar",
						email = "shankar@gmail.com",
						url = "test.com"
				)
		)
)
@SpringBootApplication
public class JfsMiniProject1Application {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(JfsMiniProject1Application.class, args);
	}

}
