package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.entities.Book;

@SpringBootApplication
public class RestApiProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestApiProjectApplication.class, args);

		// ApplicationContext context =
		// SpringApplication.run(RestApiProjectApplication.class, args);

	}

}
