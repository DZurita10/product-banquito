package com.banquito.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.product.model.ProductType;
import com.banquito.product.product.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    public ProductType findById(String id) {
        return productTypeRepository.findById(id);
    }
}
