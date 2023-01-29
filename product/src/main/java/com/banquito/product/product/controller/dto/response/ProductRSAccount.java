package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRSAccount implements Serializable{
    private String codeProduct;
    private String name;

}
