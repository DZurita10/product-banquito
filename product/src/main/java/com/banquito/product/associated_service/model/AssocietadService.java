package com.banquito.product.associated_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "associatedService")
public class AssocietadService {
    
    @Id
    private String codeService;
    @Field(value = "name")
    private String name;
    @Field(value = "allow_payment")
    private String allowPayment;
    @Field(value = "payment_method")
    private String paymentMethod;
    @Field(value = "charge_vat")
    private String chargeVat;
    @Field(value = "fee")
    private Double fee;

}
