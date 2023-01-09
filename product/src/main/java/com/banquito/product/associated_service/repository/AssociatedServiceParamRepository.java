package com.banquito.product.associated_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.associated_service.model.AssociatedServiceParam;

public interface AssociatedServiceParamRepository extends MongoRepository<AssociatedServiceParam, Long>{
    List<AssociatedServiceParam> findAll(); 
    List<AssociatedServiceParam> findByCodeAssociatedServiceParam(String codeParam);
    List<AssociatedServiceParam> findByValueType(String name);
    List<AssociatedServiceParam> findByName(String status);    
}
