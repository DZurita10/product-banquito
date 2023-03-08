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
    private String capitalization;
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

    public Product() {
    }

    public Product(String id, String name, String status, Date startDate, Date endDate, String capitalization,
            String temporalyAccountState, String useCheckbook, String allowTransference, String typeClient,
            String minOpeningBalance, InterestRateProduct interestRate,
            List<AssociatedServiceProduct> associatedService, ProductTypeModel productType, Long version) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capitalization = capitalization;
        this.temporalyAccountState = temporalyAccountState;
        this.useCheckbook = useCheckbook;
        this.allowTransference = allowTransference;
        this.typeClient = typeClient;
        this.minOpeningBalance = minOpeningBalance;
        this.interestRate = interestRate;
        this.associatedService = associatedService;
        this.productType = productType;
        this.version = version;
    }

}
