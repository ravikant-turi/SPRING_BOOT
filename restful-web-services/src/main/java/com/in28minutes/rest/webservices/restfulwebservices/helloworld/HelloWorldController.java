package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String helloWorld() {
		return "Helloworld";
	}
}
