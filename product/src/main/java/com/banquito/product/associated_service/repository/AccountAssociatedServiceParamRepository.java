package com.banquito.product.associated_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;

public interface AccountAssociatedServiceParamRepository extends MongoRepository<AccountAssociatedServiceParam, Long>{
   
}
