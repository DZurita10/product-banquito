package com.banquito.product.associated_service.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class AccountAssociatedServiceParam {
    
    @Id
    private String codeAccountServiceParam;
    @Indexed(unique = true)


    @Field("associated_service_param")
    private AssociatedServiceParam associatedServiceParam;

    @Field("status")
    private String status;
    @Field("text_value")
    private String textValue;
    @Field("date_value")
    private Date dateValue;
    @Field("number_value")
    private BigDecimal numberValue;
    @Field("create_date")
    private Date createDate;
    @Field("end_date")
    private Date endDate;
}
