package com.banquito.product.mock;

import java.util.Optional;

import com.banquito.product.product.model.InterestRateProduct;

public class InterestRateProductMock {
    public static InterestRateProduct mockInterestRate(Optional<String> id, Optional<String> name) {
        return InterestRateProduct.builder()
                .id(!id.isPresent() ? "12345" : id.get())
                .name(!name.isPresent() ? "Sample" : name.get())
                .type("MONTH")
                .calcBase("365 2")
                .build();
    }
}
