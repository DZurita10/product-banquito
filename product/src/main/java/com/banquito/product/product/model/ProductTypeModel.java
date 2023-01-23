package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeModel {

    private String id;
    private String name;
    private String status;
    
    public ProductTypeModel() {
    }
    public ProductTypeModel(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    
}
