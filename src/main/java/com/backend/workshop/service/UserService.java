package com.backend.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.workshop.entities.User;
import com.backend.workshop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository; 
	
	public List<User> findAllUsers() {	
		return repository.findAll();
	}
	
	public User findUserById(Long id) {
		Optional<User> userId = repository.findById(id);
		return userId.get();
	}
		
}
