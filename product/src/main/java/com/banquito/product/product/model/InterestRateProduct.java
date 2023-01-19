package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestRateProduct {
    private String id;
    private String name;
    private String type;
    private String calcBase;

}
