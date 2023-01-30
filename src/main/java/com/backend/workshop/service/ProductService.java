package com.backend.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.workshop.entities.Product;
import com.backend.workshop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findProductById(Long id) {
		Optional<Product> idProduct = productRepository.findById(id);
		return idProduct.get();
	}
}
