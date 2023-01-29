package com.banquito.product.associated_service.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountServiceAssociatedParamRS {
    
    private String status;
    private String textValue;
    
}
