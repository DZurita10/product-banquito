package com.banquito.product.product.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.banquito.product.product.model.ProductType;

public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType, Long>{
    List<ProductType> findAll();
    List<ProductType> findByCodeProductType(String codeProductType);    
}
