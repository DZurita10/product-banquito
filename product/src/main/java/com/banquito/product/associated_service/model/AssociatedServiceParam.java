package com.banquito.product.associated_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "associated_service_param")
@NoArgsConstructor
public class AssociatedServiceParam {
    
    @Id
    public String codeParam;
    @Indexed(unique = true)
    
    @Field("value_type")
    public String valueType;
    @Field("name")
    public String name;

}
