package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.product.controller.dto.request.ProductRq;
import com.banquito.product.product.controller.dto.response.ProductRs;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;
    

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<ProductRs>> getProduct() {
        List<Product> products = this.productService.findAll();
        List<ProductRs> productRs = new ArrayList<>();
        for(Product product : products) {
            ProductRs productR = new ProductRs();
            productR.setCodeProduct(product.getCodeProduct());
            productR.setName(product.getName());
            productR.setStatus(product.getStatus());
            productR.setInterestRate(product.getInterestRate());
            productR.setAssociatedService(product.getAssociatedService());
            productR.setProductType(product.getProductType());
            productRs.add(productR);
        }
        return ResponseEntity.ok(productRs);
    }

    @ResponseBody
    @RequestMapping(value = "/product/{nameProduct}", method = RequestMethod.GET)
    public ResponseEntity<ProductRs> getProductByName(String nameProduct) {
        Product products = this.productService.findByName(nameProduct);
        ProductRs productR = new ProductRs();
        productR.setCodeProduct(products.getCodeProduct());
        productR.setName(products.getName());
        productR.setStatus(products.getStatus());
        productR.setProductType(products.getProductType());
        return ResponseEntity.ok(productR);
    }

    @ResponseBody
    @RequestMapping(value = "/product/{status}", method = RequestMethod.GET)
    public String status(String status) {
        return "Hello Product Status " + status;
    }

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public void insertProduct(ProductRq productRq) {
        this.productService.saveProduct(productRq);
    }
    
    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateProduct() {
        return "Hello Product";
    }
}
