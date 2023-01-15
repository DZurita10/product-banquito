package com.banquito.product.associated_service.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountServiceAssociatedParamRQ {
    
    private String status;
    private String textValue;
}
