package com.banquito.product.associated_service.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssociatedServiceParam {
    
    
    public String valueType;
    public String name;

    List<AccountAssociatedServiceParam> account;

}
