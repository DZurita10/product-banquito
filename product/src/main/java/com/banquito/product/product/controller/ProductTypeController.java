package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banquito.product.product.controller.dto.request.ProductTypeRQ;
import com.banquito.product.product.controller.dto.response.ProductTypeRS;
import com.banquito.product.product.controller.mapper.ProductTypeMapper;
import com.banquito.product.product.controller.mapper.ProductTypeSaveMapper;
import com.banquito.product.product.model.ProductType;
import com.banquito.product.product.service.ProductTypeService;

@Controller
@RequestMapping("api/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @ResponseBody
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<ProductTypeRS> findAll() {

        List<ProductType> productType = productTypeService.findAll();
        List<ProductTypeRS> productTypeRs = new ArrayList<>();

        ProductTypeMapper productTypeMapper = new ProductTypeMapper();
        productTypeRs = productTypeMapper.toProductType(productType);

        return productTypeRs;

    }

    @ResponseBody
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ProductTypeRS findById(String id) {
        ProductType productType = productTypeService.findById(id);
        ProductTypeRS productTypeRS = ProductTypeRS.builder()
                .id(productType.getId())
                .name(productType.getName())
                .type(productType.getType())
                .allowEarnInterest(productType.getAllowEarnInterest())
                .allowGenAccState(productType.getAllowGenAccState())
                .temporalyInterest(productType.getTemporalyInterest())
                .products(productType.getProducts())
                .build();

        return productTypeRS;
    }

    @ResponseBody
    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody ProductTypeRQ productTypeRQ) {
        ProductTypeSaveMapper productTypeMapper = new ProductTypeSaveMapper();
        ProductType productType = productTypeMapper.toProductType(productTypeRQ);
        productTypeService.saveProductType(productType);
        return ResponseEntity.ok("ProductType saved");
    }

}
