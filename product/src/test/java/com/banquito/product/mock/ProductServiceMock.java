package com.banquito.product.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.model.Product;

public class ProductServiceMock {
    public static ProductRQ mockProductRQ() {
        return ProductRQ.builder()
                .name("Ahorro Programado")
                .status("ACTIVO")
                .startDate(new Date())
                .endDate(new Date())
                .temporalyAccountState("PROCESS")
                .useCheckbook("Y")
                .allowTransference("Y")
                .typeClient("NORMAL")
                .minOpeningBalance("0")
                .interestRate(null)
                .associatedService(null)
                .productType(null)
                .build();
    }

    public static Product mockProduct(Optional<String> id, Optional<String> name, Optional<String> status) {
        return Product.builder()
                .id(!id.isPresent() ? "12345" : id.get())
                .name(!name.isPresent() ? "Ahorro Programado" : name.get())
                .status(!status.isPresent() ? "ACTIVO" : status.get())
                .startDate(new Date())
                .endDate(new Date())
                .temporalyAccountState("PROCESS")
                .useCheckbook("Y")
                .allowTransference("Y")
                .typeClient("NORMAL")
                .minOpeningBalance("0")
                .interestRate(InterestRateProductMock.mockInterestRate(Optional.empty(), Optional.empty()))
                .associatedService(null)
                .productType(null)
                .build();
    }

    public static Optional<Product> mockOptionalProduct() {
        return Optional.of(mockProduct(Optional.empty(), Optional.empty(), Optional.empty()));
    }

    public static List<Product> mockListOfProducts() {
        List<Product> products = new ArrayList<>();
        products.add(mockProduct(Optional.of("12345"), Optional.empty(), Optional.of("ACTIVE")));
        products.add(mockProduct(Optional.of("12346"), Optional.empty(), Optional.of("INACTIVE")));
        products.add(mockProduct(Optional.of("12347"), Optional.empty(), Optional.of("INACTIVE")));
        products.add(mockProduct(Optional.of("12348"), Optional.empty(), Optional.of("ACTIVE")));
        products.add(mockProduct(Optional.of("12349"), Optional.empty(), Optional.of("ACTIVE")));
        return products;
    }
}
