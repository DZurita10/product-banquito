package com.banquito.product.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociatedServiceProduct {
    private String id;
    private String name;
    private String allowPayment;
    private String paymentMethod;
    private String chargeVat;
    private Double fee;
    
    public AssociatedServiceProduct() {
    }
    public AssociatedServiceProduct(String id, String name, String allowPayment, String paymentMethod, String chargeVat,
            Double fee) {
        this.id = id;
        this.name = name;
        this.allowPayment = allowPayment;
        this.paymentMethod = paymentMethod;
        this.chargeVat = chargeVat;
        this.fee = fee;
    }

    
}
