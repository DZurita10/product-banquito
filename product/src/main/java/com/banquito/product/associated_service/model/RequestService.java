package com.banquito.product.associated_service.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collation = "request")
public class RequestService {
    @Id
    private String codeRequest;

    @Indexed(unique = true)
    @Field(value = "account_number")
    private String accountNumber;

    @Field(value = "full_name")
    private String fullName;

    @Field(value = "satatus")
    private Boolean status;

    @Field(value = "start_date")
    private Date startDate;

    @Field(value = "end_date")
    private Date endDate;
    
}
