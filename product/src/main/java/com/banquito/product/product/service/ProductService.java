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

        if (product.getInterestRate() == null) {
            return "Interest rate not found";
        } else if (interestRateRepository.findById(product.getInterestRate().getId()) == null) {
            return "Interest rate not found";
        }
        if (product.getAssociatedService().isEmpty()) {
            return "Associated service not found";
        } else {
            for (int i = 0; i < product.getAssociatedService().size(); i++) {
                if (associetadServiceRepository.findById(product.getAssociatedService().get(i).getId()) == null) {
                    return "Associated service not found";
                }
            }
        }
        return "Product validated";
    }

    public void linkAssociatedServices(List<Product> prods, List<AssociatedServiceProduct> services) {
        if (rulesToLink(prods, services)) {
            for (Product prod : prods) {
                prod.setAssociatedService(services);
                try {
                    this.productRepository.save(prod);
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
