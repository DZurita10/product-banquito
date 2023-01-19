package com.banquito.product.product.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
    private String id;
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
