package com.blog.Blog_app_api;

import com.blog.Blog_app_api.dto.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class BlogAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}


	@Bean
	public  ModelMapper modelMapper(){
	 	return new ModelMapper();
	}

}
