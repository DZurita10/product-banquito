package com.banquito.product.product.controller.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class InterestRateLogRQ implements Serializable {
    private BigDecimal value;
}
