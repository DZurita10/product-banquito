package com.banquito.product.request_service.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestServiceRS implements Serializable{

    private String codeRequest;
    private Boolean status;
    private LocalDateTime startDate;
    
}
