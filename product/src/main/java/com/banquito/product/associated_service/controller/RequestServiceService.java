package com.banquito.product.associated_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/request-service")
public class RequestServiceService {
    

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String account() {
        return "Hello account";
    }

    @ResponseBody
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String requestService() {
        return "Request Service";
    }

    @ResponseBody
    @RequestMapping(value = "/request", method = RequestMethod.PUT)
    public String updateStatusRequets() {
        return "New request";
    }

    
}
