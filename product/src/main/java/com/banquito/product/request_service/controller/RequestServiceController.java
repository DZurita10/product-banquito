package com.banquito.product.request_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.product.request_service.service.RequestServiceService;

@RestController
@RequestMapping("api/request-service")
public class RequestServiceController {

    private final RequestServiceService requestServiceService;

    public RequestServiceController(RequestServiceService requestServiceService) {
        this.requestServiceService = requestServiceService;
    }

    

    
    
}
