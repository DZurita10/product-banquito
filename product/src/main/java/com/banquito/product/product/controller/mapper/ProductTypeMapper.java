package com.banquito.product.product.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.banquito.product.product.controller.dto.response.ProductTypeRS;
import com.banquito.product.product.model.ProductType;

public class ProductTypeMapper {

    public List<ProductTypeRS> toProductType(List<ProductType> productType) {

        List<ProductTypeRS> productTypeRs = productType.stream().map(product -> ProductTypeRS.builder()
                .id(product.getId())
                .name(product.getName())
                .type(product.getType())
                .allowEarnInterest(product.getAllowEarnInterest())
                .allowGenAccState(product.getAllowGenAccState())
                .temporalyInterest(product.getTemporalyInterest())
                .build()).collect(Collectors.toList());

        return productTypeRs;
    }
}
