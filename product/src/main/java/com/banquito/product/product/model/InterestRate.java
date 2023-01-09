package com.banquito.product.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "interest_rate")
@NoArgsConstructor
public class InterestRate {
    @Id
    private String codeInterestRate;
    @Field("name")
    private String name;
    @Field("type")
    private String type;
    @Field("calc_base")
    private String calcBase;

    
}
