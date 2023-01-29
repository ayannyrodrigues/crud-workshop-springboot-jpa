package com.backend.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.workshop.entities.Category;
import com.backend.workshop.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> idCategory = categoryRepository.findById(id);
		return idCategory.get();
	}

}
