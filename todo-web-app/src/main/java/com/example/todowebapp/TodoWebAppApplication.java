package com.example.todowebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.todowebapp")
public class TodoWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoWebAppApplication.class, args);
	}

}
