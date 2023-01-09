package com.banquito.product.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/products")
public class ProductTypeController {
    @ResponseBody
    @RequestMapping(value = "/product-type", method = RequestMethod.GET)
    public String productType() {
        return "Hello product-type";
    }

    @ResponseBody
    @RequestMapping(value = "/product-type/{nameProductType}", method = RequestMethod.GET)
    public String product(String nameProductType) {
        return "Hello product-type " + nameProductType;
    }

    @ResponseBody
    @RequestMapping(value = "/product-type", method = RequestMethod.POST)
    public String insertProductType() {
        return "Hello product-type";
    }
    
}
