package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.controller.dto.response.ProductRS;
import com.banquito.product.product.controller.mapper.ProductMapper;
import com.banquito.product.product.controller.mapper.ProductMapperSave;
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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProductRS> findAll() {
        List<Product> product = productService.findAll();
        List<ProductRS> productRs = new ArrayList<>();

        ProductMapper productMapper = new ProductMapper();
        productRs = productMapper.toProduct(product);

        return productRs;

    }

    @ResponseBody
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public ProductRS findByName(String name) {
        Product product = productService.findByName(name);
        ProductRS productRS = ProductRS.builder()
                .name(product.getName())
                .status(product.getStatus())
                .build();

        return productRS;
    }

    @ResponseBody
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<ProductRS> findByStatus(String status) {
        log.info("status: " + status);
        List<Product> product = productService.findByStatus(status);
        List<ProductRS> productRs = new ArrayList<>();

        ProductMapper productMapper = new ProductMapper();
        productRs = productMapper.toProduct(product);

        return productRs;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@RequestBody ProductRQ productRQ) {
        ProductMapperSave productMapperSave = new ProductMapperSave();
        Product product = productMapperSave.toProduct(productRQ);

        return productService.saveProduct(product);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(String name, String status) {
        Product product = productService.findByName(name);
        return productService.updateProduct(status, product);
    }
}