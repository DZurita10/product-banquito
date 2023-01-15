package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.InterestRate;

public interface InterestRateRepository extends MongoRepository<InterestRate, Long>{
    InterestRate findById(String id);
    List<InterestRate> findAll();
    List<InterestRate> findByNameLike(String name);

}
