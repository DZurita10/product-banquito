package com.banquito.product.associated_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banquito.product.associated_service.controller.dto.AccountServiceAssociatedParamRQ;
import com.banquito.product.associated_service.controller.mapper.AccountServiceAssociatedParamMapper;
import com.banquito.product.associated_service.service.AssocietadServiceService;

@Controller
@RequestMapping("api/account-associated-service-param")
public class AccountServiceAssociatedParamController {

    private final AssocietadServiceService associetadServiceParam;

    public AccountServiceAssociatedParamController(AssocietadServiceService associetadServiceParam) {
        this.associetadServiceParam = associetadServiceParam;
    }

    @ResponseBody
    @RequestMapping(value = "/account-associated-service-param", method = RequestMethod.POST)
    public ResponseEntity<String> createAccountServiceAssociatedParam(@RequestBody AccountServiceAssociatedParamRQ paramRQ){
        try {
            this.associetadServiceParam.createAccountServiceAssociatedParam(AccountServiceAssociatedParamMapper.toAccountParam(paramRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }  
    }
}

