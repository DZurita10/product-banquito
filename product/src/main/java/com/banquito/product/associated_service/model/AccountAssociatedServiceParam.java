package com.banquito.product.associated_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AccountAssociatedServiceParam {
    
    @Id
    private String codeAccountServiceParam;
    @Indexed(unique = true)



    private AssociatedServiceParam associatedServiceParam;

    private String codeAccount; ///
   
    private String status;
    
    private String textValue;
    
    private LocalDateTime dateValue;
    
    private BigDecimal numberValue;
    
    private LocalDateTime createDate;

    private LocalDateTime endDate;
}
