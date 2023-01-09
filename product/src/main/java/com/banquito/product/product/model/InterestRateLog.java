package com.banquito.product.product.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "interest_rate_log")
@NoArgsConstructor
public class InterestRateLog {
    @Id
    private String codeInterestRateLog;
    @Field("vaue")
    private BigDecimal  value;
    @Field("start_date")
    private Timestamp startDate;
    @Field("end_date")
    private Timestamp endDate;
    @Field("interest_rate")
    private InterestRate interestRate;
    @Field("status")
    private String status;
    
}
