package com.banquito.product.associated_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;
import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AccountAssociatedServiceParamRepository;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;

@Service
public class AssocietadServiceService {
    private final AssocietadServiceRepository associatedRepository;
    private final AccountAssociatedServiceParamRepository  paramRepository;


    public AssocietadServiceService(AssocietadServiceRepository associatedRepository,
            AccountAssociatedServiceParamRepository paramRepository) {
        this.associatedRepository = associatedRepository;
        this.paramRepository = paramRepository;
    }

    public List<AssocietadService> findAllAssociatedServices(){
        return this.associatedRepository.findAll();
    }

    public void crearAssociatedService(AssocietadService associetadService){
        this.associatedRepository.save(associetadService);
    }

    //vincula un AssociatedServiceParam a un AssociatedService localizado por su nombre
    public void vincularParam(String name, AssociatedServiceParam param){
        AssocietadService associetadService = this.associatedRepository.findByName(name).get(0);
        List<AssociatedServiceParam> auxList = associetadService.getParams();
        auxList.add(param);
        associetadService.setParams(auxList);
        this.associatedRepository.save(associetadService);

    }

    public void createAssociatedServiceParam(AssocietadService param){
        this.associatedRepository.save(param);
    }

    public void createAccountServiceAssociatedParam(AccountAssociatedServiceParam param){
        this.paramRepository.save(param);
    }
}
