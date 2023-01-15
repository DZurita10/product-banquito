package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.InterestRate;

public interface InterestRateRepository extends MongoRepository<InterestRate, Long>{
    InterestRate findByCodeInterestRate(String codeInterestRate);
    List<InterestRate> findAll();
    List<InterestRate> findByNameLike(String name);
    // Find by interest rate log
    List<InterestRate> findByInterestRateLogValue(Double value);
    // Find by interest rate log status
    List<InterestRate> findByInterestRateLogStatus(String status);
    

}
