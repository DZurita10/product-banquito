package com.banquito.product.associated_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.product.associated_service.model.AssocietadService;

public interface AssocietadServiceRepository  extends MongoRepository<AssocietadService, String>{
    
    List<AssocietadService> findByName(String name);

    List<AssocietadService> findByParamsAccountCodeAccount(String codeAccountParam);
    Optional<AssocietadService> findByIdAndParamsAccountCodeAccount(String Id,String codeAccountParam);

}
