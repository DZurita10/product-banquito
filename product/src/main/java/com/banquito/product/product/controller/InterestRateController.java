package com.banquito.product.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("api/interest-rate")
public class InterestRateController {

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String interestRate() {
        return "Hello Interest Rate";
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate/{nameInterestRate}", method = RequestMethod.GET)
    public String interestRate(String nameInterestRate) {
        return "Hello Interest Rate " + nameInterestRate;
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate/{interestRateType}", method = RequestMethod.GET)
    public String interestRateType(String interestRateType) {
        return "Hello Interest Rate Type " + interestRateType;
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate/{status}", method = RequestMethod.GET)
    public String status(String status) {
        return "Hello Interest Rate Status " + status;
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate", method = RequestMethod.POST)
    public String insertInterestRate() {
        return "Hello Interest Rate";
    }
    
    @ResponseBody
    @RequestMapping(value = "/interest-rate", method = RequestMethod.PUT)
    public String updateInterestRate() {
        return "Hello Interest Rate";
    }
}

