package com.myblog.myblog;

import com.myblog.myblog.entity.Role;
import com.myblog.myblog.repository.RoleRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.naming.NameAlreadyBoundException;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Blog App REST APIs",
				description = "Spring Boot Blog App REST APIs Documentation",
				version = "v.0",
				contact = @Contact(
						name = "Ahmat",
						email = "ahissen1998@gmail.com",
						url = "https://github.com/Ahmat98/main"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/Ahmat98/main/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Blog App REST APIs Documentation",
				url = "https://github.com/Ahmat98/main"
		)
)
public class MyblogApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;


	@Override
	public void run(String... args) throws Exception {

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);

	}
}
