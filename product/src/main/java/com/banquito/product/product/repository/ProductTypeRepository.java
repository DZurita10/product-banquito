package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banquito.product.product.model.ProductType;

@Repository
public interface ProductTypeRepository extends MongoRepository<ProductType, Long>{
    List<ProductType> findAll();
    List<ProductType> findByCodeProductType(String codeProductType);    
}
