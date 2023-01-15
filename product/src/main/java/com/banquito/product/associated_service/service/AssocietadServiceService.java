package com.banquito.product.associated_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;

@Service
public class AssocietadServiceService {
    private final AssocietadServiceRepository associatedRepository;

    public AssocietadServiceService(AssocietadServiceRepository associatedRepository) {
        this.associatedRepository = associatedRepository;
    }

    public List<AssocietadService> findAllAssociatedServices() {
        return this.associatedRepository.findAll();
    }

    public void crearAssociatedService(AssocietadService associetadService) {
        try {
            this.associatedRepository.save(associetadService);
        } catch (Exception e) {
            new RuntimeException("Problemas al guardar el servicio asociado:" + e);
        }

    }
}
