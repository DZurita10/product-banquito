package com.banquito.product.associated_service.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "associated_service_param")
@NoArgsConstructor
public class AssociatedServiceParam {
    
    public String valueType;
    public String name;

}
