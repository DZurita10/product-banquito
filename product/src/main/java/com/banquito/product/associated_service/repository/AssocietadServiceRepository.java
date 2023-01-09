package com.banquito.product.associated_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.banquito.product.associated_service.model.AssocietadService;

public interface AssocietadServiceRepository  extends MongoRepository<AssocietadService, String>{
    
    @Query("{name:'?0'}")
    AssocietadService findItemByName(String name);
}
