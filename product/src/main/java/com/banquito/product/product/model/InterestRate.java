package com.banquito.product.product.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "interest_rate")
@NoArgsConstructor
public class InterestRate {
    @Id
    private String id;
    private String name;
    private String type;
    private String calcBase;

    List<InterestRateLog> interestRateLog;

    
}
