package com.banquito.product.associated_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.associated_service.model.AssocietadService;

public interface AssocietadServiceRepository  extends MongoRepository<AssocietadService, String>{
    
    AssocietadService findItemByName(String name);
}
