package com.banquito.product.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.banquito.product.product.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    //vincular una lista de productos a una lista de servicios
    //json {"products": [{ArrayList<Products>}],
    //      "associatedServices": [{ArrayList<Products>}]
    //      }
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String updateProduct(@RequestBody Map<String, Object> json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Product products = objectMapper.convertValue(json.get("products"), Product.class); 
        //Product products = ((Product)json.get("products"));
        return products.toString();
    }
}
