package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeModel {

    private String id;
    private String name;
    
}
