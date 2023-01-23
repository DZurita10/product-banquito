package com.banquito.product.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.product.model.InterestRate;

public interface InterestRateRepository extends MongoRepository<InterestRate, Long>{
    Optional<InterestRate> findById(String id);
    List<InterestRate> findAll();
    List<InterestRate> findByNameLike(String name);
    List<InterestRate> findByType(String type);
    // buscar por el status de cada interes rate log
    List<InterestRate> findByInterestRateLogsStatus(String status);
    // buscar por nombre conteniendo la palabra sin importar mayusculas y minusculas
    List<InterestRate> findByNameContainingIgnoreCase(String name);
    // buscar si la lista interestRateLogs es diferente de null y por el status
    List<InterestRate> findByInterestRateLogsIsNotNullAndInterestRateLogsStatus(String status);





}
