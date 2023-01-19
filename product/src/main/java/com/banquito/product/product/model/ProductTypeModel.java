package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeModel {

    private String codeProductType;
    private String name;
    private String status;
    
}
