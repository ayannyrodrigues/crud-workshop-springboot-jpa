package com.backend.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.workshop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
