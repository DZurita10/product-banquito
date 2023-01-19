package com.banquito.product.product.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.model.InterestRateLog;
import com.banquito.product.product.repository.InterestRateRepository;

@Service
public class InterestRateService {
    private final InterestRateRepository interestRateRepository;

    public InterestRateService(InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    public InterestRate createInterestRate(InterestRate interestRate) {
        // Setear el valor de la tasa de interes
        List<InterestRateLog> interestRateLog = new ArrayList<InterestRateLog>();
        interestRate.setInterestRateLog(interestRateLog);
        return interestRateRepository.save(interestRate);
    }


    // FinfAll
    public List<InterestRate> findAll() {
        return interestRateRepository.findAll();
    }

    // FindById
    public InterestRate findById(String id) {
        return interestRateRepository.findById(id);
    }

    // FindByName
    public List<InterestRate> findByName(String name) {
        return interestRateRepository.findByNameLike(name);
    }

    // FindByType
    public List<InterestRate> findByType(String type) {
        return interestRateRepository.findByType(type);
    }

    // Add InterestRateLog
    public void addInterestRateLog(String id, InterestRateLog interestRateLog) {
        InterestRate interestRateFound = interestRateRepository.findById(id);
        // Setear el valor de la tasa de interes
        interestRateLog = setInteresRateLog(interestRateLog);
        // Agregar el nuevo registro de tasa de interes
        interestRateFound.getInterestRateLog().add(interestRateLog);
        System.out.println(interestRateFound);
        interestRateRepository.save(interestRateFound);
    }

    InterestRateLog setInteresRateLog(InterestRateLog interestRateLog) {
        interestRateLog.setStatus("INA");
        // now timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        interestRateLog.setStartDate(timestamp);
        return interestRateLog;
    }







}
