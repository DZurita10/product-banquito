package com.banquito.product.associated_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "associatedService")
@Data
public class AssocietadService {
    
    @Id
    private String _id;
    private String name;
    private String allowPayment;
    private String paymentMethod;
    private String chargeVat;
    private Double fee;

}
