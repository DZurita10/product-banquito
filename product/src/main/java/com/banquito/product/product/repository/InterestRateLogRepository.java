package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.InterestRateLog;

public interface InterestRateLogRepository extends MongoRepository<InterestRateLog, Long>{
    List<InterestRateLog> findAll(); 
    List<InterestRateLog> findByValueLike(String value);
    List<InterestRateLog> findByStatus(String status);    
}
