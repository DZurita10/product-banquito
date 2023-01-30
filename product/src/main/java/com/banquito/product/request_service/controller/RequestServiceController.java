package com.banquito.product.request_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.request_service.controller.dto.RequestServiceRQ;
import com.banquito.product.request_service.controller.dto.RequestServiceRS;
import com.banquito.product.request_service.controller.mapper.RequestServiceMapper;
import com.banquito.product.request_service.model.RequestService;
import com.banquito.product.request_service.service.RequestServiceService;

@RestController
@RequestMapping("api/request-service")
@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
public class RequestServiceController {

    private final RequestServiceService requestServiceService;

    public RequestServiceController(RequestServiceService requestServiceService) {
        this.requestServiceService = requestServiceService;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RequestService>> findAllRequestService() {
        List<RequestService> requestServices = requestServiceService.findAll();
        if(requestServices != null) return ResponseEntity.ok(requestServices);
        else return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{codeRequest}", method = RequestMethod.GET)
    public ResponseEntity<RequestServiceRS> getRequestAssociatedService(@PathVariable String codeRequest){
        try {
            RequestService requestService = requestServiceService.getRequestAssociatedService(codeRequest);
            RequestServiceRS requestServiceRS = RequestServiceMapper.map(requestService);
            return ResponseEntity.ok(requestServiceRS);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RequestService> createAssociatedService(@RequestBody RequestServiceRQ requestServiceRQ) {
        try {

            RequestService savedRequestService = requestServiceService
                    .saveRequestService(RequestServiceMapper.map(requestServiceRQ));

            return ResponseEntity.ok(savedRequestService);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @RequestMapping(value = "/{codeRequest}/{status}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAssociatedService(@PathVariable String codeRequest,
            @PathVariable Boolean status) {
        try {
            requestServiceService.updateRequestService(codeRequest, status);
            return ResponseEntity.ok("se actualizo correctamente");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

}
