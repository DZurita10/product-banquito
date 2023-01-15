package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banquito.product.product.controller.dto.response.InterestRateRS;
import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.service.InterestRateService;

@Controller
@RequestMapping("api/interest-rate")
public class InterestRateController {

    private InterestRateService interestRateService;

    @GetMapping
    public ResponseEntity<List<InterestRateRS>> getInterestRates() {
        List<InterestRateRS> interestRatesRS = new ArrayList<>();
        List<InterestRate> interestRates = interestRateService.findAll();
        for (InterestRate interestRate : interestRates) {
            interestRatesRS.add(this.toInterestRateRS(interestRate));
        }
        return ResponseEntity.ok(interestRatesRS);

    }

    InterestRateRS toInterestRateRS(InterestRate interestRate) {
        return InterestRateRS.builder().id(interestRate.getId()).name(interestRate.getName())
                .build();
    }

}
