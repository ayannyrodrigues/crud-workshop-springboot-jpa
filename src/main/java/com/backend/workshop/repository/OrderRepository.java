package com.backend.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.workshop.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
