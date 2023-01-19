package com.banquito.product.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

/*     @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<ProductRS>> getProduct() {
        
    }

    @ResponseBody
    @RequestMapping(value = "/product/{nameProduct}", method = RequestMethod.GET)
    public ResponseEntity<ProductRS> getProductByName(String nameProduct) {
        
    } */

    @ResponseBody
    @RequestMapping(value = "/product/{status}", method = RequestMethod.GET)
    public String status(String status) {
        return "Hello Product Status " + status;
    }

/*     @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public void insertProduct(ProductRQ productRq) {
        this.productService.saveProduct(productRq);
    } */
    
    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateProduct() {
        return "Hello Product";
    }
}
