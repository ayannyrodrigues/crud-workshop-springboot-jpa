package com.backend.workshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.workshop.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> getAllUsers() {
		User userResponse = new User(1L, "Maria", "maria@gmail.com", "999001122", "abcd.1234");
		return ResponseEntity.ok().body(userResponse);
		
	}

}
