package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestRateProductRS implements Serializable{
    private String id;
    private String name;
    private BigDecimal value;
    private String calcBase;
}
