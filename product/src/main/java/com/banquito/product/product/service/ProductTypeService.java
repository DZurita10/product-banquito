package com.banquito.product.product.service;


import org.springframework.stereotype.Service;

import com.banquito.product.product.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }
    
}
