package com.banquito.product.associated_service.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParamRQ {
    private String name;
    private String value;
    
    public ParamRQ() {
    }
    public ParamRQ(String name, String value) {
        this.name = name;
        this.value = value;
    }

    
}
