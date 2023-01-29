package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.controller.dto.response.ProductRS;
import com.banquito.product.product.controller.mapper.ProductMapper;
import com.banquito.product.product.controller.mapper.ProductMapperSave;
import com.banquito.product.product.model.AssociatedServiceProduct;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseBody
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductRS> findAll() {
        List<Product> product = productService.findAll();
        List<ProductRS> productRs = new ArrayList<>();

        ProductMapper productMapper = new ProductMapper();
        productRs = productMapper.toProduct(product);

        return productRs;

    }

    @ResponseBody
    @RequestMapping(value = "/name-product", method = RequestMethod.GET)
    public ProductRS findByName(String name) {
        Product product = productService.findByName(name);
        ProductRS productRS = ProductRS.builder()
                .id(product.getId())
                .name(product.getName())
                .status(product.getStatus())
                .productType(product.getProductType())
                .build();

        return productRS;
    }

    @ResponseBody
    @RequestMapping(value = "/status-product", method = RequestMethod.GET)
    public List<ProductRS> findByStatus(String status) {
        log.info("status: " + status);
        List<Product> product = productService.findByStatus(status);
        List<ProductRS> productRs = new ArrayList<>();

        ProductMapper productMapper = new ProductMapper();
        productRs = productMapper.toProduct(product);

        return productRs;
    }

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveProduct(@RequestBody ProductRQ productRQ) {
        ProductMapperSave productMapperSave = new ProductMapperSave();
        Product product = productMapperSave.toProduct(productRQ);

        return productService.saveProduct(product);
    }

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(String name, String status) {
        Product product = productService.findByName(name);
        return productService.updateProduct(status, product);
    }

    //vincular una lista de productos a una lista de servicios
    //json {"products": [{ArrayList<Products>}],
    //      "associatedServices": [{ArrayList<Products>}]
    //      }
    @ResponseBody
    @RequestMapping(value = "/product-link-service", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@RequestBody Map<String, Object> json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = objectMapper.convertValue(json.get("products"), new TypeReference<List<Product>>() {}); 
        List<AssociatedServiceProduct> services = objectMapper.convertValue(json.get("associatedServices")
            ,new TypeReference<List<AssociatedServiceProduct>>() {});
        try {
            this.productService.linkAssociatedServices(products, services);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok("Vinculacion exitosa");
    }
}
