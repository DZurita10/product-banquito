package com.banquito.product.product.service;

import org.springframework.stereotype.Service;

import com.banquito.product.product.controller.dto.request.ProductRq;
import com.banquito.product.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public void saveProduct(ProductRq productRq) {
        productRq.getProductType().forEach(productType -> {
            productType.getProducts().forEach(product -> {
                productRepository.save(product);
            });
        });
    }
}
