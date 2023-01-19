package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.ProductType;

public interface ProductTypeRepository extends MongoRepository<ProductType, Long> {
    List<ProductType> findAll();
}
