package com.banquito.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.product.controller.dto.response.ProductTypeRs;
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

    public ProductTypeRs getProductTypeByName(String name){
        ProductType productType = this.productTypeRepository.findByName(name);
        ProductTypeRs productTypeRs = new ProductTypeRs();
        productTypeRs.setCodeProductType(productType.getCodeProductType());
        productTypeRs.setName(productType.getName());
        return productTypeRs;
    }
    
}
