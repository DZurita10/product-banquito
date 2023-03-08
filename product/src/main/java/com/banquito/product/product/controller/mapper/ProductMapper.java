package com.banquito.product.product.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.banquito.product.product.controller.dto.response.ProductRS;
import com.banquito.product.product.controller.dto.response.ProductRSInterest;
import com.banquito.product.product.model.Product;

public class ProductMapper {
    public List<ProductRS> toProduct(List<Product> products) {
        List<ProductRS> productRS = products.stream().map(product -> ProductRS.builder()
                .id(product.getId())
                .name(product.getName())
                .status(product.getStatus())
                .productType(product.getProductType())
                .associatedService(product.getAssociatedService())
                .build()).collect(Collectors.toList());

        return productRS;
    }
    public static List<ProductRSInterest> toProductRSinterest(List<Product> products) {
        List<ProductRSInterest> productRS = products.stream().map(product -> ProductRSInterest.builder()
                .id(product.getId())
                .name(product.getName())
                .productType(product.getProductType().getName())
                .interest(product.getInterestRate().getName())
                .capitalization(product.getCapitalization())
                .baseCalc("")
                .build()).collect(Collectors.toList());

        return productRS;
    }
}
