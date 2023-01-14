package com.banquito.product.associated_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.banquito.product.associated_service.model.AssociatedServiceParam;

@Repository
public interface AssociatedServiceParamRepository extends MongoRepository<AssociatedServiceParam, String> {
    List<AssociatedServiceParam> findAll();

}
