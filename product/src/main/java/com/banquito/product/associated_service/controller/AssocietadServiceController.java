package com.banquito.product.associated_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "/product/test";
    }
}
