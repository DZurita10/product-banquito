package com.banquito.product.request_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.request_service.model.RequestService;

public interface RequestServiceRepository extends MongoRepository<RequestService, String> {

    RequestService findByAccountNumber(String accountNumber);

    RequestService findByStatus(Boolean status);

    Optional<RequestService> findByCodeRequest(String codeRequest);

}
