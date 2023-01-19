package com.banquito.product.product.controller.mapper;

import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.model.Product;

public class ProductMapper {
    public static Product toProduct(ProductRQ productRQ){
        return Product.builder()
                .name(productRQ.getName())
                .status(productRQ.getStatus())
                .startDate(productRQ.getStartDate())
                .endDate(productRQ.getEndDate())
                .temporalyAccountState(productRQ.getTemporalyAccountState())
                .useCheckbook(productRQ.getUseCheckbook())
                .allowTransference(productRQ.getAllowTransference())
                .typeClient(productRQ.getTypeClient())
                .minOpeningBalance(productRQ.getMinOpeningBalance())
                .build();
    }    
}
