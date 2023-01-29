package com.banquito.product.product.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestRateLog {

    private BigDecimal value;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;



}
