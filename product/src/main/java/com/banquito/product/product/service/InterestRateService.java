package com.banquito.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.repository.InterestRateRepository;

@Service
public class InterestRateService {
    private final InterestRateRepository interestRateRepository;

    public InterestRateService(InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    public void saveInterestRate() {
        // 
        

    }

    // FinfAll
    public List<InterestRate> findAll() {
        return interestRateRepository.findAll();
    }

    


}
