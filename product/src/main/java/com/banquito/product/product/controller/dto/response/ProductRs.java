package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;

import com.banquito.product.product.model.ProductTypeModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRS implements Serializable {
    private String id;
    private String name;
    private String status;
    private ProductTypeModel productType;

}
