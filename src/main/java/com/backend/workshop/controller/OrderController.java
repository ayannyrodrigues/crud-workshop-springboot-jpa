package com.backend.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.workshop.entities.Order;
import com.backend.workshop.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return ResponseEntity.ok().body(service.findAllOrders());		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findOrderById(id));
	}

}
