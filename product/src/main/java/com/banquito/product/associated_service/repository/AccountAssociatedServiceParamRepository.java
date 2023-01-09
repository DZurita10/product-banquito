package com.banquito.product.associated_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;

public interface AccountAssociatedServiceParamRepository extends MongoRepository<AccountAssociatedServiceParam, Long>{
    List<AccountAssociatedServiceParam> findAll(); 
    List<AccountAssociatedServiceParam> findByCodeAccountAssociatedServiceParam(String codeProduct);
    List<AccountAssociatedServiceParam> findByStatus(String name);   
}

