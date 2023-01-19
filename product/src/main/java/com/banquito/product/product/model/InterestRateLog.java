package com.banquito.product.product.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestRateLog {

    private BigDecimal value;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;



}
