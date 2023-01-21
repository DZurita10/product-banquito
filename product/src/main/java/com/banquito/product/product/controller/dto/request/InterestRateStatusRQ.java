package com.banquito.product.product.controller.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data

public class InterestRateStatusRQ implements Serializable {
    private String id;
    private String status;
}
