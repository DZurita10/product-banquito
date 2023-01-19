package com.banquito.product.product.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.banquito.product.product.controller.dto.request.ProductRq;
import com.banquito.product.product.controller.dto.response.ProductTypeRs;
import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.model.ProductType;
import com.banquito.product.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeService productTypeService;
    private final InterestRateService interestRateService;

    public ProductService(ProductRepository productRepository, ProductTypeService productTypeService, InterestRateService interestRateService) {
        this.productRepository = productRepository;
        this.productTypeService = productTypeService;
        this.interestRateService = interestRateService;
    }

    public void saveProduct(ProductRq productRq) {
        try {
            Product product = new Product();
            //String productTypeName = productRq.getProductType().getName();
            //ProductTypeRs productType = productTypeService.getProductTypeByName(productTypeName);

            //product.setCodeProduct(generateCodeProduct());
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

            productRepository.save(product);
        } catch (Exception e) {
            throw e;
        }
    }

    public String generateCodeProduct() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
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
