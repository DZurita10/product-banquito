package com.banquito.product.product.controller.mapper;

import com.banquito.product.product.controller.dto.request.ProductUpdateRQ;
import com.banquito.product.product.model.Product;

public class ProductMapperUpdate {
    public Product toProduct(ProductUpdateRQ productUpdateRQ) {
        Product product = Product.builder()
                .status(productUpdateRQ.getStatus())
                .build();

        return product;
    }
}
