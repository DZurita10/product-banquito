package com.banquito.product.associated_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;

@RestController
@RequestMapping("/product")
public class AssocietadServiceController {
    
    private final AssocietadServiceRepository associetadServiceRepo;

    public AssocietadServiceController(AssocietadServiceRepository associetadServiceRepo) {
        this.associetadServiceRepo = associetadServiceRepo;
    }

    @GetMapping("test")
    public String getTest() {
        return "/product/test a";
    }

    @ResponseBody
    @RequestMapping(value = "/associatedServices", method = RequestMethod.GET)
    public String findAllAssociatedServices() {
        return "TODO findAllAssociatedServices";
    }

     
    @ResponseBody
    @RequestMapping(value = "/associatedService", method = RequestMethod.POST)
    public String saveAssociatedService(@RequestBody AssocietadService associetadService) {
        return "TODO saveAssociatedService";
    }

    /* @ResponseBody
    @RequestMapping(value = "/linkAssociatedService", method = RequestMethod.PUT)
    public String linkProductToAssociatedService(@RequestBody Product Product) {
        return "TODO linkProductToAssociatedService";
    } */


}
