package com.banquito.product.associated_service.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;

public interface AccountAssociatedServiceParamRepository extends MongoRepository<AccountAssociatedServiceParam, Long>{
    List<AccountAssociatedServiceParam> findAll(); 
    List<AccountAssociatedServiceParam> findByCodeAccountServiceParam(String codeAccountServiceParam);
    List<AccountAssociatedServiceParam> findByStatus(String status);   
}
