package com.banquito.product.product.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.product.controller.dto.response.ProductTypeRs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String codeProduct;
    @Indexed(unique = true)

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
    private List<ProductTypeRs> productType;

    @Version
    private Long version;
}
