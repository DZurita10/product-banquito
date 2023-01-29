package com.banquito.product.request_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;
import com.banquito.product.request_service.Utils.Utils;
import com.banquito.product.request_service.model.RequestService;
import com.banquito.product.request_service.repository.RequestServiceRepository;

@Service
public class RequestServiceService {

    private final RequestServiceRepository requestServiceRepository;
    private final AssocietadServiceRepository associetadServiceRepository;

    public RequestServiceService(RequestServiceRepository requestServiceRepository,
            AssocietadServiceRepository associetadServiceRepository) {
        this.requestServiceRepository = requestServiceRepository;
        this.associetadServiceRepository = associetadServiceRepository;
    }

    public RequestService getRequestAssociatedService(String codeRequest){

        Optional<RequestService> opRequestService = this.requestServiceRepository.findByCodeRequest(codeRequest);
        if (opRequestService.isPresent()) {
            RequestService requestService = opRequestService.get();
            try {
                return requestService;
            } catch (Exception e) {
                throw new RuntimeException("No se a encontrado la solicitud");
            }
        } else {
            throw new RuntimeException("La solicitud no existe");
        }
        
    }

    @Transactional
    public RequestService saveRequestService(RequestService requestService) {

        String codeUnique = Utils.generateNumberCode(10);
        requestService.setCodeRequest(codeUnique);
        requestService.setStartDate(Utils.currentDate());
        requestService.setStatus(true);
        requestService.setEndDate(null);
        AssocietadService opAssociateService = this.associetadServiceRepository
                .findByName(requestService.getNameAssociatedService()).get(0);

        
        if (opAssociateService != null) {
            requestService.setNameAssociatedService(opAssociateService.getName());

        } else {

            throw new RuntimeException("El servicio no existe" + opAssociateService);

        }

        try {
            this.requestServiceRepository.save(requestService);
        } catch (Exception e) {
            throw new RuntimeException("Problemas al guardar la solicitud");
        }

        return requestService;
    }

    @Transactional
    public void updateRequestService(String codeRequest, Boolean status) {
        Optional<RequestService> opRequestService = this.requestServiceRepository.findByCodeRequest(codeRequest);
        if (opRequestService.isPresent()) {
            RequestService requestService = opRequestService.get();
            requestService.setStatus(status);
            requestService.setEndDate(Utils.currentDate());
            try {
                this.requestServiceRepository.save(requestService);
            } catch (Exception e) {
                throw new RuntimeException("Problemas al actualizar ");
            }
        } else {
            throw new RuntimeException("La solicitud no existe");
        }

    }

}
