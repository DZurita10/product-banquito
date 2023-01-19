package com.banquito.product.product.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "productType")
public class ProductType {
    @Id
    private String id;
    @Indexed(unique = true)

    private String name;
    private String type;
    private String allowEarnInterest;
    private String allowGenAccState;
    private String temporalyInterest;

    private List<ProductModel> products;

    @Version
    private Long version;
}
