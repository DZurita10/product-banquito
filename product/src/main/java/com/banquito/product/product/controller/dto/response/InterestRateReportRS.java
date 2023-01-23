package com.banquito.product.product.controller.dto.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestRateReportRS {
    private String id;
    private String name;
    private String type;
    private BigDecimal value;
    private String calcBase;
    private String status;

    
}
