package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banquito.product.product.controller.dto.request.InterestRateLogRQ;
import com.banquito.product.product.controller.dto.response.InterestRateRS;
import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.model.InterestRateLog;
import com.banquito.product.product.service.InterestRateService;

@Controller
@RequestMapping("api/interest-rate")
public class InterestRateController {

    private InterestRateService interestRateService;

    public InterestRateController(InterestRateService interestRateService) {
        this.interestRateService = interestRateService;
    }

    @GetMapping
    public ResponseEntity<List<InterestRateRS>> getInterestRates() {
        List<InterestRateRS> interestRatesRS = new ArrayList<>();
        List<InterestRate> interestRates = interestRateService.findAll();
        for (InterestRate interestRate : interestRates) {
            interestRatesRS.add(this.toInterestRateRS(interestRate));
        }
        return ResponseEntity.ok(interestRatesRS);

    }

    @GetMapping("/{id}")
    public ResponseEntity<InterestRate> getInterestRateById(@PathVariable("id") String id) {
        InterestRate interestRate = interestRateService.findById(id);
        if (interestRate == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(interestRate);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<InterestRate>> getInterestRateByName(@PathVariable("name") String name) {
        List<InterestRate> interestRates = interestRateService.findByName(name);
        if (interestRates == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(interestRates);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<InterestRate>> getInterestRateByType(@PathVariable("type") String type) {
        List<InterestRate> interestRates = interestRateService.findByType(type);
        if (interestRates == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(interestRates);
    }

    @PostMapping
    public ResponseEntity<String> createInterestRate(@RequestBody InterestRate interestRate) {
        try {
            interestRateService.createInterestRate(interestRate);
            return ResponseEntity.ok("Interes creado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el interes");
        }
    }

    @PostMapping("/add-interest-rate-log/{id}")
    public ResponseEntity<String> addInterestRateLog(@PathVariable("id") String id,
            @RequestBody InterestRateLogRQ interestRateLogRQ) {
        try {
            interestRateService.addInterestRateLog(id, toInterestRateLog(interestRateLogRQ));
            return ResponseEntity.ok(   "Interes Agregado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al crear el interes");
        }
    }

    InterestRateRS toInterestRateRS(InterestRate interestRate) {
        return InterestRateRS.builder().id(interestRate.getId()).name(interestRate.getName())
                .build();
    }

    InterestRateLog toInterestRateLog(InterestRateLogRQ interestRateLogRQ) {
        return InterestRateLog.builder().value(interestRateLogRQ.getValue()).build();
    }

}
