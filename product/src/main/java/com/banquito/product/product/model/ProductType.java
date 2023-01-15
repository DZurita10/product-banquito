package com.banquito.product.product.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.banquito.product.product.controller.dto.response.ProductRs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "productType")
@NoArgsConstructor
public class ProductType {
    @Id
    private String id;
    private String codeProductType;
    @Indexed(unique = true)

    private String name;
    private String type;
    private String allowEarnInterest;
    private String allowGenAccState;
    private String temporalyInterest;

    private List<ProductRs> products;

}
