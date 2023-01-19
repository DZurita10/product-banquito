package com.banquito.product.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.product.associated_service.repository.AssocietadServiceRepository;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.repository.InterestRateRepository;
import com.banquito.product.product.repository.ProductRepository;
import com.banquito.product.product.repository.ProductTypeRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final InterestRateRepository interestRateRepository;
    private final AssocietadServiceRepository associetadServiceRepository;

    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository,
            InterestRateRepository interestRateRepository, AssocietadServiceRepository associetadServiceRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.interestRateRepository = interestRateRepository;
        this.associetadServiceRepository = associetadServiceRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByStatus(String status) {
        try {
            return productRepository.findByStatus(status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String saveProduct(Product product) {

        String validate = productValidate(product);
        if (validate != "Product validated") {
            return validate;
        }

        if (productTypeRepository.findById(product.getProductType().getId()) == null) {
            return "Product type not found";
        } else {
            try {
                productRepository.save(product);
                return "Product saved";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ResponseEntity<String> updateProduct(String status, Product product) {

        if (productRepository.findByName(product.getName()) == null) {
            return ResponseEntity.badRequest().body("Product not found");
        }

        try {
            product.setStatus(status);
            productRepository.save(product);
            return ResponseEntity.ok("Product updated");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    public String productValidate(Product product) {
        if (product.getInterestRate() != null) {
            for (int i = 0; i < product.getInterestRate().size(); i++) {
                if (interestRateRepository.findById(product.getInterestRate().get(i).getId()) == null) {
                    return "Interest rate not found";
                }
            }
        } else {
            return "Interest rate not found";
        }
        if (product.getAssociatedService() != null) {
            for (int i = 0; i < product.getAssociatedService().size(); i++) {
                if (associetadServiceRepository.findById(product.getAssociatedService().get(i).getId()) == null) {
                    return "Associated service not found";
                }
            }
        } else {
            return "Associated service not found";
        }
        return "Product validated";
    }

}
