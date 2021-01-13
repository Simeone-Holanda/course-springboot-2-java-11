package com.empresa.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.webservices.entities.Category;
import com.empresa.webservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
