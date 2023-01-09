package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banquito.product.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{
    List<Product> findAll(); 
    List<Product> findByCodeProduct(String codeProduct);
    List<Product> findByNameLike(String name);
    List<Product> findByStatus(String status);    
}
