package com.banquito.product.product.controller.mapper;

import com.banquito.product.product.controller.dto.request.ProductTypeRQ;
import com.banquito.product.product.model.ProductType;

public class ProductTypeSaveMapper {

    public ProductType toProductType(ProductTypeRQ productTypeRQ) {
        ProductType productType = ProductType.builder()
                .name(productTypeRQ.getName())
                .type(productTypeRQ.getType())
                .allowEarnInterest(productTypeRQ.getAllowEarnInterest())
                .allowGenAccState(productTypeRQ.getAllowGenAccState())
                .temporalyInterest(productTypeRQ.getTemporalyInterest())
                .products(productTypeRQ.getProducts())
                .build();

        return productType;
    }
}
