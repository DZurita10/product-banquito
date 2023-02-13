package com.banquito.product.mock;

import java.util.Date;

import com.banquito.product.product.model.Product;

public class ProductMock {

    public static Product mockProduct() {

        return Product.builder()
            .id("123")
            .name("Nombre")
            .status("ACT")
            .startDate(new Date())
            .endDate(new Date())
            .temporalyAccountState("Estado")
            .useCheckbook("Si")
            .allowTransference("Si")
            .typeClient("Tipo")
            .minOpeningBalance("0")
            .interestRate(null)
            .associatedService(null)
            .productType(null)
            .build();
    }
}
