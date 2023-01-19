package com.banquito.product.product.controller.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductUpdateRQ {
    private String status;
}
