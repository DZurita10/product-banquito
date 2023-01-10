package com.banquito.product.associated_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/associated-service-param")
public class AssociatedServiceParamController {
    
    @ResponseBody
    @RequestMapping(value = "/associated-service-param", method = RequestMethod.GET)
    public String associatedServiceParam() {
        return "Hello Service Associated Param";
    }

    @ResponseBody
    @RequestMapping(value = "/associated-service-param/{valueType}", method = RequestMethod.GET)
    public String associatedServiceParamType(String valueType) {
        return "Hello Service Associated Param " + valueType;
    }

    @ResponseBody
    @RequestMapping(value = "/associated-service-param/{name}", method = RequestMethod.GET)
    public String associatedServiceParamName(String name) {
        return "Hello Service Associated Param" + name;
    }

    @ResponseBody
    @RequestMapping(value = "/associated-service-param", method = RequestMethod.POST)
    public String insertAssociatedServiceParam() {
        return "Hello Service Associated Param";
    }
    
    @ResponseBody
    @RequestMapping(value = "/associated-service-param", method = RequestMethod.PUT)
    public String updateAssociatedServiceParam() {
        return "Hello Service Associated Param";
    }
}
