package com.backend.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.workshop.entities.Category;
import com.backend.workshop.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok().body(service.findAllCategories());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> getByIdCategory(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
}
