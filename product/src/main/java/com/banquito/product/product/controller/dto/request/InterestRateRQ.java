package com.banquito.product.product.controller.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class InterestRateRQ implements Serializable {
    private String id;
    private BigDecimal value;
}
