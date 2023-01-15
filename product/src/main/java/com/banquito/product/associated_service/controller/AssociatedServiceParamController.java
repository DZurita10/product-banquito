package com.banquito.product.associated_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.service.AssocietadServiceService;

@Controller
@RequestMapping("api/associated-service-param")
public class AssociatedServiceParamController {
    
    private final AssocietadServiceService associetadServiceParam;

    

    public AssociatedServiceParamController(AssocietadServiceService associetadServiceParam) {
        this.associetadServiceParam = associetadServiceParam;
    }

    @ResponseBody
    @RequestMapping(value = "/associatedServiceParam", method = RequestMethod.POST)
    public ResponseEntity<String> createAssociatedServiceParam(@RequestBody AssocietadService associetadService) {
        try{
            this.associetadServiceParam.createAssociatedServiceParam(associetadService);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/associatedServiceParam", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAssociatedServiceParam(
                                                                @PathVariable String name,
                                                                @RequestBody AssociatedServiceParam associatedServiceParam) 
                                                    {
		this.associetadServiceParam.vincularParam(name, associatedServiceParam);
		return ResponseEntity.ok("Param's Information updated");
	}
}
