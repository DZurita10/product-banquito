package com.banquito.product.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.product.associated_service.repository.AssocietadServiceRepository;
import com.banquito.product.product.model.AssociatedServiceProduct;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.repository.InterestRateRepository;
import com.banquito.product.product.repository.ProductRepository;
import com.banquito.product.product.repository.ProductTypeRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final InterestRateRepository interestRateRepository;

    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository,
            InterestRateRepository interestRateRepository, AssocietadServiceRepository associetadServiceRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.interestRateRepository = interestRateRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
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

    public ResponseEntity<String> saveProduct(Product product) {

        String validate = productValidate(product);
        if (validate != "Product validated") {
            return ResponseEntity.badRequest().body(validate);
        }

        if (productTypeRepository.findById(product.getProductType().getId()) == null) {
            return ResponseEntity.badRequest().body("Product type is required");
        } else {
            try {
                productRepository.save(product);
                return ResponseEntity.ok("Product saved");
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

        if (product.getInterestRate() == null) {
            return ("Interest rate is required");
        } else if (interestRateRepository.findById(product.getInterestRate().getId()) == null) {
            return ("Interest rate is required");
        }

        return ("Product validated");
    }

    public void linkAssociatedServices(List<Product> prods, List<AssociatedServiceProduct> services) {
        if (rulesToLink(prods, services)) {
            Product product;
            for (Product prod : prods) {
                product = this.productRepository.findById(prod.getId()).orElse(null);
                // product.setAssociatedService(services);
                for (AssociatedServiceProduct service : services) {
                    product.getAssociatedService().add(service);
                }
                try {
                    this.productRepository.save(product);
                } catch (Exception e) {
                    throw new RuntimeException("error guardando el producto: " + e);
                }

            }
        } else
            throw new RuntimeException("Vinculacion no valida por reglas del negocio");
    }

    public boolean rulesToLink(List<Product> prods, List<AssociatedServiceProduct> services) {
        boolean band = true;
        for (Product prod : prods) {
            if (prod.getName().contains("Inversion"))
                band = false;
            if (prod.getName().contains("ahorros")) {
                for (AssociatedServiceProduct service : services) {
                    if (service.getName().contains("chequera"))
                        band = false;
                }
            }
        }
        return band;
    }
}
