package com.banquito.product.product.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "product_type")
@NoArgsConstructor
public class ProductType {
    @Id
    private String id;
    private String codeProductType;
    @Indexed(unique = true)

    private String name;
    private String nameProductType;
    private String allowWarnInterest;
    private String allowGenAccState;
    private String temporalyInterest;

    private List<Product> products;

}
