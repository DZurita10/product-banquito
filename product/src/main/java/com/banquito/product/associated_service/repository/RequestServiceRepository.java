package com.banquito.product.associated_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.associated_service.model.RequestService;

public interface RequestServiceRepository extends MongoRepository<RequestService, String>{

    List<RequestService> findByAccountNumber(String accountNumber);
    List<RequestService> findByStatus(Boolean status);
    
}
