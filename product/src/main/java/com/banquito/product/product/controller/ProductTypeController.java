package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banquito.product.product.controller.dto.response.ProductTypeRs;
import com.banquito.product.product.model.ProductType;
import com.banquito.product.product.service.ProductTypeService;

@Controller
@RequestMapping("api/products")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @ResponseBody
    @RequestMapping(value = "/product-type", method = RequestMethod.GET)
    public List<ProductTypeRs> productType() {
        List<ProductType> productType = this.productTypeService.findAll();
        List<ProductTypeRs> productTypeRs = new ArrayList<>();
        for (ProductType product : productType) {
            ProductTypeRs productR = new ProductTypeRs();
            productR.setName(product.getName());
            productR.setType(product.getType());
            productR.setAllowEarnInterest(product.getAllowEarnInterest());
            productR.setAllowGenAccState(product.getAllowGenAccState());
            productR.setTemporalyInterest(product.getTemporalyInterest());
            productR.setProducts(product.getProducts());            
            productTypeRs.add(productR);
        }
        return productTypeRs;
    }

    @ResponseBody
    @RequestMapping(value = "/product-type/{nameProductType}", method = RequestMethod.GET)
    public ProductTypeRs product(String nameProductType) {
        return this.productTypeService.getProductTypeByName(nameProductType);
    }

    @ResponseBody
    @RequestMapping(value = "/product-type", method = RequestMethod.POST)
    public String insertProductType() {
        return "Hello product-type";
    }

}
