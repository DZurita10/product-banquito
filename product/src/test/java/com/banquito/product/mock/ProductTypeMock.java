package com.banquito.product.mock;

import java.util.ArrayList;
import java.util.List;

import com.banquito.product.product.model.ProductType;

public class ProductTypeMock {

    public static List<ProductType> mockListOfProductType() {
        List<ProductType> productsType = new ArrayList();
        productsType.add(mockProductType());
        return productsType;
    }

    public static ProductType mockProductType() {
        return ProductType.builder()
        .name("Test")
        .id("123")
        .allowEarnInterest("Interest")
        .type("Tipo")
        .temporalyInterest("Interes")
        .allowGenAccState("Estado")
        .products(null)
        .build();
    }
}
