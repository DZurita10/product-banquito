package com.banquito.product.product.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.banquito.product.product.controller.dto.response.ProductRS;
import com.banquito.product.product.model.Product;

public class ProductMapper {
    public List<ProductRS> toProduct(List<Product> products) {
        List<ProductRS> productRS = products.stream().map(product -> ProductRS.builder()
                .name(product.getName())
                .status(product.getStatus())
                .build()).collect(Collectors.toList());

        return productRS;
    }
}
