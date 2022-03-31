package com.StarWarsApi.bookApi;

import com.StarWarsApi.bookApi.model.Jedi;
import com.StarWarsApi.bookApi.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com.StarWarsApi.bookApi.*" })
public class StarWarsApiBookApplication {

	public static void main(String[] args) {
		Jedi jedi = new Jedi();
		jedi.setId(102);
		jedi.setEmail("john.doe@gmail.com");
		jedi.setName("John DOE");

		//userRepository.save(jedi);
		SpringApplication.run(StarWarsApiBookApplication.class, args);
	}

}
