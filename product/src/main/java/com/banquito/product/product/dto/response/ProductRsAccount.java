package com.banquito.product.product.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRsAccount implements Serializable {
    private String codeProduct;
    private String name;    
}
