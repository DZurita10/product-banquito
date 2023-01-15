package com.banquito.product.product.controller.dto.response;

import java.io.Serializable;
import java.util.List;

import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.product.model.InterestRate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRs implements Serializable{
    private String codeProduct;
    private String name;
    private String status;
    private List<InterestRate> interestRate;
    private List<AssociatedServiceParam> associatedService;
    private List<ProductTypeRs> productType;
}
