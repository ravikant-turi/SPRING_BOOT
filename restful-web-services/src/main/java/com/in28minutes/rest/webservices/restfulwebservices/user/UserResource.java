package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.*;

@RestController
public class UserResource {
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// GET USER
	// ALL :
	@GetMapping(path = "/users")
	public List<User> retriveAllUser() {
		return service.findAll();
	}

	// PARTICLULAR ONE
	@GetMapping(path = "/users/{id}")
	public User retriveAllUserById(@PathVariable int id) {

		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid  @RequestBody User user) {

		User savedeUser = service.save(user);

		// return : /users/4 instead of 201

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedeUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	
	@PostMapping(path = "/users/{id}")
	public void DeleteUserById(@PathVariable int id) {
		 service.deleteById(id-1);
		
		
	}

}
