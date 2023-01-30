package com.banquito.product.associated_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountAssociatedServiceParam {
    
    private String codeAccount; ///
    private String status;
    private String textValue;
    private LocalDateTime dateValue; 
    private BigDecimal numberValue;  
    private LocalDateTime createDate;
    private LocalDateTime endDate;

    public AccountAssociatedServiceParam() {
    }
    
    public AccountAssociatedServiceParam(String codeAccount, String status, String textValue, LocalDateTime dateValue,
            BigDecimal numberValue, LocalDateTime createDate, LocalDateTime endDate) {
        this.codeAccount = codeAccount;
        this.status = status;
        this.textValue = textValue;
        this.dateValue = dateValue;
        this.numberValue = numberValue;
        this.createDate = createDate;
        this.endDate = endDate;
    }

    
}
