package com.banquito.product.associated_service.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.service.AssocietadServiceService;

@Controller
@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
@RequestMapping("/api/associatedServiceParam")
public class AssociatedServiceParamController {
    
    private final AssocietadServiceService associetadServiceParam;

    

    public AssociatedServiceParamController(AssocietadServiceService associetadServiceParam) {
        this.associetadServiceParam = associetadServiceParam;
    }

    @ResponseBody
    @RequestMapping(value = "/addparam/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> createAssociatedServiceParam( @PathVariable String id, @RequestBody AssociatedServiceParam param) {
        try{
            this.associetadServiceParam.addParam(id, param);;
            return ResponseEntity.ok().build();
        }catch(Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.internalServerError().build();

        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/addparam-account/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> addAccountToparam( @PathVariable String id, @RequestBody AssociatedServiceParam param) {
        try{
            this.associetadServiceParam.addAccount(id, param);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    @ResponseBody
    @RequestMapping(value = "/updateparam/{code}/{name}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateServiceAssoParam(@PathVariable String code, @PathVariable String name, @RequestBody AssociatedServiceParam param) {                                               
		try {
            this.associetadServiceParam.updateServiceAssoParam(code, name, param);
		    return ResponseEntity.ok("Param's Information updated");
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();

        }       
	}


    @ResponseBody
    @RequestMapping(value = "/associatedServicesParam/{code}", method = RequestMethod.GET)
    public ResponseEntity<Optional<AssocietadService>> findAssociatedServicesParamCode( @PathVariable String code) {
        Optional<AssocietadService> associatedServices = associetadServiceParam.findByCode(code);
        if(associatedServices != null) return ResponseEntity.ok(associatedServices);
        else return ResponseEntity.notFound().build();
    }

}