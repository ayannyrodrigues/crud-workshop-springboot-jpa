package com.backend.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.workshop.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
