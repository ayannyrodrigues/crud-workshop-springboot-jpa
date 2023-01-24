package com.backend.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.workshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
}
