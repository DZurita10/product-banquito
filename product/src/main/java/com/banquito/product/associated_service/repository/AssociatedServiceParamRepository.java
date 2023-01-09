package com.banquito.product.associated_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.associated_service.model.AssociatedServiceParam;

public interface AssociatedServiceParamRepository extends MongoRepository<AssociatedServiceParam, String>{
    List<AssociatedServiceParam> findAll(); 
    List<AssociatedServiceParam> findByCodeAssociatedServiceParam(String codeParam);
  
}
