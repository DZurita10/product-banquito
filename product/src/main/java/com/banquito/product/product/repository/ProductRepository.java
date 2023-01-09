package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{
    List<Product> findAll(); 
    List<Product> findByCodeProduct(String codeProduct);
    List<Product> findByNameLike(String name);
    List<Product> findByStatus(String status);    
}
