package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductTypeRs implements Serializable {
    private String codeProductType;
    private String name;
    private String type;
    private String allowEarnInterest;
    private String allowGenAccState;
    private String temporalyInterest;

    private List<ProductRS> products;

}
