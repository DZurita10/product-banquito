package com.banquito.product.product.controller.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.product.controller.dto.response.ProductTypeRs;
import com.banquito.product.product.model.InterestRate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRq implements Serializable{
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private String temporalyAccountState;
    private String useCheckbook;
    private String allowTransference;
    private String typeClient;
    private String minOpeningBalance;

    private List<InterestRate> interestRate;
    private List<AssociatedServiceParam> associatedService;
    private ProductTypeRs productType;    
}
