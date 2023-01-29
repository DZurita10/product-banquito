package com.banquito.product.associated_service.controller.mapper;

import com.banquito.product.associated_service.controller.dto.AccountServiceAssociatedParamRS;
import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;

public class AccountServiceAssociatedParamMapper {
    public static AccountAssociatedServiceParam  toAccountParam(AccountServiceAssociatedParamRS rq){
        return AccountAssociatedServiceParam.builder()
                                        .status(rq.getStatus())
                                        .textValue(rq.getStatus()).build();
    }
    
}
