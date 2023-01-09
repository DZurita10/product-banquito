package com.banquito.product.associated_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/associatedserviceparam")
public class AssociatedServiceParamController {
    
    @ResponseBody
    @RequestMapping(value = "/associatedserviceparam", method = RequestMethod.GET)
    public String associatedserviceparam() {
        return "Hello Product";
    }
}
