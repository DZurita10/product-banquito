package com.banquito.product.product.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterestRateLog {

    private BigDecimal value;
    private Timestamp startDate;
    private Timestamp endDate;
    private InterestRate interestRate;
    private String status;

}
