package com.backend.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.workshop.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
}
