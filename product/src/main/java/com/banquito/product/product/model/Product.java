package com.banquito.product.product.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "product")
@NoArgsConstructor
public class Product {
    @Id
    private String codeProduct;
    @Indexed(unique = true)
    //private InterestRate interest;
    @Field("name")
    private String name;
    @Field("status")
    private String status;
    @Field("startDate")
    private Date startDate;
    @Field("endDate")
    private Date endDate;
    @Field("temporalyAccountState")
    private String temporalyAccountState;
    @Field("useCheckbook")
    private String useCheckbook;
    @Field("allowTransference")
    private String allowTransference;
    @Field("typeClient")
    private String typeClient;
    @Field("minOpeningBalance")
    private String minOpeningBalance;
    //private AssociatedService associatedService;


}
