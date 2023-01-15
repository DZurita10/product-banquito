package com.banquito.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.product.controller.dto.request.ProductRq;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeService productTypeService;

    public ProductService(ProductRepository productRepository, ProductTypeService productTypeService) {
        this.productRepository = productRepository;
        this.productTypeService = productTypeService;
    }

    public void saveProduct(ProductRq productRq) {
        try {
            Product product = new Product();
            product.setCodeProduct("000022112233");
            product.setName(productRq.getName());
            product.setStatus(productRq.getStatus());
            product.setStartDate(productRq.getStartDate());
            product.setEndDate(productRq.getEndDate());
            product.setTemporalyAccountState(productRq.getTemporalyAccountState());
            product.setUseCheckbook(productRq.getUseCheckbook());
            product.setAllowTransference(productRq.getAllowTransference());
            product.setTypeClient(productRq.getTypeClient());
            product.setMinOpeningBalance(productRq.getMinOpeningBalance());
            product.setInterestRate(productRq.getInterestRate());
            product.setAssociatedService(productRq.getAssociatedService());
            product.setProductType(productRq.getProductType());

            productRepository.save(product);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Product> findAll() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findByName(String name) {
        try {
            return productRepository.findByNameLike(name);
        } catch (Exception e) {
            throw e;
        }
    }
}
