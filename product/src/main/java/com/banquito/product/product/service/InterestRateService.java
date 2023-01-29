package com.banquito.product.product.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return interestRateRepository.save(interestRate);
    }

    // FinfAll
    public List<InterestRate> findAll() {

        return interestRateRepository.findAll();
    }

    // FindById
    public Optional<InterestRate> findById(String id) {
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
    public void addInterestRateLog(InterestRate interestRate) {
        Optional<InterestRate> interestRateFound = interestRateRepository.findById(interestRate.getId());
        InterestRateLog interestRateLog = InterestRateLog.builder()
                .value(interestRate.getInterestRateLogs().get(0).getValue())
                .startDate(LocalDateTime.now()).status("INA").build();

        if (!interestRateFound.isPresent()) {
            throw new RuntimeException("No se encontro la tasa de interes");
        }
        if (interestRateFound.get().getInterestRateLogs() == null) {
            List<InterestRateLog> interestRateLogList = new ArrayList<InterestRateLog>();
            interestRateFound.get().setInterestRateLogs(interestRateLogList);
        }else{
            interestRateFound.get().getInterestRateLogs().get(interestRateFound.get().getInterestRateLogs().size() - 1).setEndDate(LocalDateTime.now());
            interestRateFound.get().getInterestRateLogs().get(interestRateFound.get().getInterestRateLogs().size() - 1).setStatus("INA");
        }
        interestRateFound.get().getInterestRateLogs().add(interestRateLog);
        interestRateRepository.save(interestRateFound.get());
    }

    // Update state InterestRateLog
    public void updateStateInterestRateLog(InterestRate interestRate) {
        Optional<InterestRate> interestRateFound = interestRateRepository.findById(interestRate.getId());
        if (!interestRateFound.isPresent()) {
            throw new RuntimeException("No se encontro la tasa de interes");
        }
        // Setear el valor de la tasa de interes
        if (interestRateFound.get().getInterestRateLogs().size() > 0) {
            interestRateFound.get().getInterestRateLogs().get(interestRateFound.get().getInterestRateLogs().size() - 1)
                    .setStatus(interestRate.getInterestRateLogs().get(0).getStatus());
        }
        System.out.println(interestRateFound);
        interestRateRepository.save(interestRateFound.get());
    }

    // nombre conteniendo la palabra sin importar mayusculas y minusculas
    public List<InterestRate> findByNameContainingIgnoreCase(String name) {
        return interestRateRepository.findByNameContainingIgnoreCase(name);
    }

    // buscar si la lista interestRateLogs es diferente de null y por el status

    public Optional<InterestRate> getInterestRateProduct(String id) {
        Optional<InterestRate> interestRateFound = interestRateRepository.findById(id);
        if (!interestRateFound.isPresent()) {
            throw new RuntimeException("No se encontro la tasa de interes");
        }
        return interestRateFound;
    }

    public List<InterestRate> getByStatus(String status) {
        return interestRateRepository.findByInterestRateLogsStatus(status);
    }

    // Get InterestRateLog.value where InterestRateLog.status = ACT

}
