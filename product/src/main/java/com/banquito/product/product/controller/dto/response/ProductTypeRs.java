package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductTypeRs implements Serializable{
    private String codeProductType;
    private String name;
}
