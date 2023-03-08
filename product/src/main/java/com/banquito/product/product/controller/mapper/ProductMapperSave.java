package com.banquito.product.product.controller.mapper;

import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.model.Product;

public class ProductMapperSave {

    public Product toProduct(ProductRQ productRQ) {
        Product product = Product.builder()
                .name(productRQ.getName())
                .status(productRQ.getStatus())
                .startDate(productRQ.getStartDate())
                .endDate(productRQ.getEndDate())
                .capitalization(productRQ.getCapitalization())
                .temporalyAccountState(productRQ.getTemporalyAccountState())
                .useCheckbook(productRQ.getUseCheckbook())
                .allowTransference(productRQ.getAllowTransference())
                .typeClient(productRQ.getTypeClient())
                .minOpeningBalance(productRQ.getMinOpeningBalance())
                .interestRate(productRQ.getInterestRate())
                .associatedService(productRQ.getAssociatedService())
                .productType(productRQ.getProductType())
                .build();

        return product;
    }
    
}
