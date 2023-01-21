package com.banquito.product.product.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "product")
public class Product {
    @Id
    private String id;
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
    private InterestRateProduct interestRate;
    private List<AssociatedServiceProduct> associatedService;
    private ProductTypeModel productType;

    @Version
    private Long version;
}
