package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductTypeRs implements Serializable{
    private String id;
    private String codeProductType;
    private String nameProductType;
    List<ProductRsAccount> products;
}
