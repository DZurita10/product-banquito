package com.banquito.product.product.service;

import org.springframework.stereotype.Service;

import com.banquito.product.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
