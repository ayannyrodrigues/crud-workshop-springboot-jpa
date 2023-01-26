package com.backend.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.workshop.entities.Order;
import com.backend.workshop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository; 
	
	public List<Order> findAllOrders() {	
		return repository.findAll();
	}
	
	public Order findOrderById(Long id) {
		Optional<Order> orderId = repository.findById(id);
		return orderId.get();		
	}
		
}
