package com.banquito.product.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banquito.product.product.controller.dto.request.InterestRateRQ;
import com.banquito.product.product.controller.dto.request.InterestRateStatusRQ;
import com.banquito.product.product.controller.dto.response.InterestRateProductRS;
import com.banquito.product.product.controller.dto.response.InterestRateRS;
import com.banquito.product.product.controller.dto.response.InterestRateReportRS;
import com.banquito.product.product.controller.mapper.InterestRateMapper;
import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.service.InterestRateService;

@Controller
@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
        org.springframework.web.bind.annotation.RequestMethod.POST,
        org.springframework.web.bind.annotation.RequestMethod.PUT,
        org.springframework.web.bind.annotation.RequestMethod.DELETE })
@RequestMapping("api/interest-rate")
public class InterestRateController {

    private InterestRateService interestRateService;

    public InterestRateController(InterestRateService interestRateService) {
        this.interestRateService = interestRateService;
    }

    @GetMapping
    public ResponseEntity<List<InterestRateReportRS>> getInterestRates() {
        List<InterestRate> interestRates = interestRateService.findAll();
        if (interestRates == null)
            return ResponseEntity.notFound().build();

        List<InterestRateReportRS> interestRateReportRSs = new ArrayList<>();
        interestRates.forEach(
                interestRate -> interestRateReportRSs.add(InterestRateMapper.mapToInterestRateReportRS(interestRate)));

        return ResponseEntity.ok(interestRateReportRSs);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InterestRateRS>> getInterestRatesAll() {
        List<InterestRateRS> interestRatesRS = new ArrayList<>();
        List<InterestRate> interestRates = interestRateService.findAll();
        for (InterestRate interestRate : interestRates) {
            interestRatesRS.add(InterestRateMapper.mapToInterestRateRS(interestRate));
        }
        return ResponseEntity.ok(interestRatesRS);

    }

    @GetMapping("/{id}")
    public ResponseEntity<InterestRate> getInterestRateById(@PathVariable("id") String id) {
        InterestRate interestRate = interestRateService.findById(id).get();
        if (interestRate == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(interestRate);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<InterestRateReportRS>> getInterestRateByNameContaining(
            @PathVariable("name") String name) {
        List<InterestRate> interestRates = interestRateService.findByNameContainingIgnoreCase(name);
        if (interestRates == null)
            return ResponseEntity.notFound().build();

        List<InterestRateReportRS> interestRateReportRSs = new ArrayList<>();
        interestRates.forEach(
                interestRate -> interestRateReportRSs.add(InterestRateMapper.mapToInterestRateReportRS(interestRate)));

        return ResponseEntity.ok(interestRateReportRSs);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<InterestRate>> getInterestRateByType(@PathVariable("type") String type) {
        List<InterestRate> interestRates = interestRateService.findByType(type);
        if (interestRates == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(interestRates);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<InterestRateProductRS> getProductInterestRate(@PathVariable("id") String id) {
        Optional<InterestRate> interestRate = interestRateService.getInterestRateProduct(id);
        if (!interestRate.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(InterestRateMapper.mapToInterestRateProductRS(interestRate.get()));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<InterestRateRS>> getInterestRateByStatus(@PathVariable("status") String status) {
        List<InterestRateRS> interestRatesRS = new ArrayList<>();
        List<InterestRate> interestRates = interestRateService.getByStatus(status);
        for (InterestRate interestRate : interestRates) {
            interestRatesRS.add(InterestRateMapper.mapToInterestRateRS(interestRate));
        }
        return ResponseEntity.ok(interestRatesRS);
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

    @PostMapping("/add-interest-rate-log")
    public ResponseEntity<String> addInterestRateLog(
            @RequestBody InterestRateRQ interestRateRQ) {
        try {
            interestRateService.addInterestRateLog(InterestRateMapper.mapToInterestRate(interestRateRQ));
            return ResponseEntity.ok("Interes Agregado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al crear el interes");
        }
    }

    // Update status
    @PutMapping("/update-status")
    public ResponseEntity<String> updateStatus(@RequestBody InterestRateStatusRQ interestRateStatusRQ) {
        try {
            interestRateService.updateStateInterestRateLog(
                    InterestRateMapper.interestRateStatusRQmapToInterestRate(interestRateStatusRQ));

            return ResponseEntity.ok("Estado del interes Actualizado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al actualizar el estado del interes");
        }
    }

}
