package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestRateProduct {
    private String id;
    private String name;
    private String type;
    private String calcBase;
    
    public InterestRateProduct() {
    }
    public InterestRateProduct(String id, String name, String type, String calcBase) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.calcBase = calcBase;
    }

}
