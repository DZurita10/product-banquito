package com.banquito.product.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "product_type")
@NoArgsConstructor
public class ProductType {
    @Id
    private String codeProductType;
    @Indexed(unique = true)

    @Field("product")
    private Product product;
    @Field("name_product_type")
    private String nameProductType;
    @Field("allow_warn_interest")
    private String allowWarnInterest;
    @Field("allow_gen_acc_state")
    private String allowGenAccState;
    @Field("temporaly_interest")
    private String temporalyInterest;

}
