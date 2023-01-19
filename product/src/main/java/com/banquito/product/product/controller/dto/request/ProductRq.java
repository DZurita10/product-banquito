package com.banquito.product.product.controller.dto.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRQ implements Serializable{
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private String temporalyAccountState;
    private String useCheckbook;
    private String allowTransference;
    private String typeClient;
    private String minOpeningBalance;

}
