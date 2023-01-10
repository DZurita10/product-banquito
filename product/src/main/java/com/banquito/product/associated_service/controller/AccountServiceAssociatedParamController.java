package com.banquito.product.associated_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/account-associated-service-param")
public class AccountServiceAssociatedParamController {
 
    @ResponseBody
    @RequestMapping(value = "/account-associated-service-param", method = RequestMethod.POST)
    public String insertAccountAssociatedServiceParam() {
        return "Hello Product";
    }
    
    @ResponseBody
    @RequestMapping(value = "/account-associated-service-param", method = RequestMethod.PUT)
    public String updateAccountAssociatedServiceParam() {
        return "Hello Account Service Associated Param";
    }

    @ResponseBody
    @RequestMapping(value = "/account-associated-service-param/{status}", method = RequestMethod.PUT)
    public String updateAccountAssociatedServiceParamStatus(String status ) {
        return "Hello Account Service Associated Param"+ status;
    }

    @ResponseBody
    @RequestMapping(value = "/account-associated-service-param/{textValue}", method = RequestMethod.PUT)
    public String updateAccountAssociatedServiceParamTextValue(String textValue ) {
        return "Hello Account Service Associated Param"+ textValue;
    }
}
