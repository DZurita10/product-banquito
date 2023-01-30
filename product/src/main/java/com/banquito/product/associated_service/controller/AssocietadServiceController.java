package com.banquito.product.associated_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.associated_service.controller.dto.ParamRQ;
import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.service.AssocietadServiceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


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
    @RequestMapping(value = "/params/{associatedServiceName}", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedServiceParam>> getParamsByAssociatedService(@PathVariable String associatedServiceName){
        List<AssociatedServiceParam> params = this.associetadServiceServ.findParamsByServiceName(associatedServiceName);
        if(params != null) return ResponseEntity.ok(params);
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
    
    // Actualiza los datos de los parametros de un servicio asociado
    // json {"idC": "asd", "paramRQ": [{"name": "par1", "valor": 10 }], "numCuenta": "111"}
    @ResponseBody
    @RequestMapping(value = "/save-params-data", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAccountParam(@RequestBody Map<String, Object> json) {
        ObjectMapper objectMapper = new ObjectMapper();
        String serviceId = objectMapper.convertValue(json.get("idC"), new TypeReference<String>() {});
        String numCuenta = objectMapper.convertValue(json.get("numCuenta"), new TypeReference<String>() {});
        List<ParamRQ> params = objectMapper.convertValue(json.get("paramRQ"), new TypeReference<List<ParamRQ>>() {});
        try {
            this.associetadServiceServ.setAccountServiceParams(serviceId, params, numCuenta);
            return ResponseEntity.ok("Se guardaron los parametros del servicio asociado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
