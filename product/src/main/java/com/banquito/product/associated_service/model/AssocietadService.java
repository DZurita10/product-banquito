package com.banquito.product.associated_service.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "associatedService")
@Data
@Builder

public class AssocietadService {
    
    @Id
    private String _id;
    private String name;
    private String allowPayment;
    private String paymentMethod;
    private String chargeVat;
    private Double fee;

    private List<AssociatedServiceParam> params;

}