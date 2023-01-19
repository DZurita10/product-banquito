package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeRS implements Serializable {
    private String id;
    private String name;
    private String type;
    private String allowEarnInterest;
    private String allowGenAccState;
    private String temporalyInterest;

    private List<ProductRS> products;

}
