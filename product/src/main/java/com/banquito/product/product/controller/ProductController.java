package com.banquito.product.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/products")
public class ProductController {

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product() {
        return "Hello Product";
    }

    @ResponseBody
    @RequestMapping(value = "/product/{nameProduct}", method = RequestMethod.GET)
    public String product(String nameProduct) {
        return "Hello Product " + nameProduct;
    }

    @ResponseBody
    @RequestMapping(value = "/product/{productType}", method = RequestMethod.GET)
    public String productType(String productType) {
        return "Hello Product Type " + productType;
    }

    @ResponseBody
    @RequestMapping(value = "/product/{status}", method = RequestMethod.GET)
    public String status(String status) {
        return "Hello Product Status " + status;
    }

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String insertProduct() {
        return "Hello Product";
    }
    
    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateProduct() {
        return "Hello Product";
    }
}
