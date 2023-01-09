package com.banquito.product.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/interest-rate-log")
public class InterestRateLogController {

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String interestRateLog() {
        return "Hello Interest Rate Log";
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate-log/{nameInterestRateLog}", method = RequestMethod.GET)
    public String interestRateLog(String nameInterestRateLog) {
        return "Hello Interest Rate Log " + nameInterestRateLog;
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate-log/{interestRateLogType}", method = RequestMethod.GET)
    public String interestRateLogType(String interestRateLogType) {
        return "Hello Interest Rate Log Type " + interestRateLogType;
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate-log/{status}", method = RequestMethod.GET)
    public String status(String status) {
        return "Hello Interest Rate Log Status " + status;
    }

    @ResponseBody
    @RequestMapping(value = "/interest-rate-log", method = RequestMethod.POST)
    public String insertInterestRateLog() {
        return "Hello Interest Rate Log";
    }
    
    @ResponseBody
    @RequestMapping(value = "/interest-rate-log", method = RequestMethod.PUT)
    public String updateInterestRateLog() {
        return "Hello Interest Rate Log";
    }
}

