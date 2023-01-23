package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {
    List<Product> findAll();
    Product findById(String id);
    Product findByName(String name);
    List<Product> findByStatus(String status);
}
