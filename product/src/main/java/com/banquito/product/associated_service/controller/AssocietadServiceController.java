package com.banquito.product.associated_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.service.AssocietadServiceService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
public class AssocietadServiceController {
    
    private final AssocietadServiceService associetadServiceServ;

    public AssocietadServiceController(AssocietadServiceService associetadServiceRepo) {
        this.associetadServiceServ = associetadServiceRepo;
    }

    
    @ResponseBody
    @RequestMapping(value = "/associatedServices", method = RequestMethod.GET)
    public ResponseEntity<List<AssocietadService>> findAllAssociatedServices() {
        List<AssocietadService> associatedServices = associetadServiceServ.findAllAssociatedServices();
        if(associatedServices != null) return ResponseEntity.ok(associatedServices);
        else return ResponseEntity.notFound().build();
    }

     
    @ResponseBody
    @RequestMapping(value = "/associatedService", method = RequestMethod.POST)
    public ResponseEntity<String> saveAssociatedService(@RequestBody AssocietadService associetadService) {
        try{
            this.associetadServiceServ.crearAssociatedService(associetadService);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
        

    /* @ResponseBody
    @RequestMapping(value = "/linkAssociatedService", method = RequestMethod.PUT)
    public String linkProductToAssociatedService(@RequestBody Product Product) {
        return "TODO linkProductToAssociatedService";
    } */


}
