package com.banquito.product.product.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "interestRate")
@Builder
public class InterestRate {
    @Id
    private String id;
    private String name;
    private String type;
    private String calcBase;

    List<InterestRateLog> interestRateLogs;


    @Version
    private Long version;
    
}
