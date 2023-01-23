package com.banquito.product.product.controller.dto.request;

import java.util.List;

import com.banquito.product.product.model.ProductModelType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeRQ {
    private String name;
    private String type;
    private String allowEarnInterest;
    private String allowGenAccState;
    private String temporalyInterest;

    private List<ProductModelType> products;
}
