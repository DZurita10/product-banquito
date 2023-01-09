package com.banquito.product.product.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "product")
@NoArgsConstructor
public class Product {
    @Id
    private String codeProduct;
    @Indexed(unique = true)
    //private InterestRate interest;
    @Field("name")
    private String name;
    @Field("status")
    private String status;
    @Field("start_date")
    private Date startDate;
    @Field("end_date")
    private Date endDate;
    @Field("temporaly_account_state")
    private String temporalyAccountState;
    @Field("use_checkbook")
    private String useCheckbook;
    @Field("allow_transference")
    private String allowTransference;
    @Field("type_client")
    private String typeClient;
    @Field("min_opening_balance")
    private String minOpeningBalance;
    //private AssociatedService associatedService;


}
