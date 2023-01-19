package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociatedServiceProduct {
    private String name;
    private String allowPayment;
    private String paymentMethod;
    private String chargeVat;
    private Double fee;
}
