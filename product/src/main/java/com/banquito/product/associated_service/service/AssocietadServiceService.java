package com.banquito.product.associated_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void vincularParam(String name, AssociatedServiceParam param){
        AssocietadService associetadService = this.associatedRepository.findByName(name).get(0);
        List<AssociatedServiceParam> auxList = associetadService.getParams();
        auxList.add(param);
        associetadService.setParams(auxList);
        this.associatedRepository.save(associetadService);

    }

    public void createAssociatedServiceParam(AssocietadService param){
        try {
            this.associatedRepository.save(param);
        } catch (Exception e) {
            new RuntimeException("Problemas al guardar el servicio asociado:" + e);
        }
    }

    public void createAccountServiceAssociatedParam(AccountAssociatedServiceParam param){
        this.paramRepository.save(param);
    }

    public void updateServiceAssoParam(String code,String name, AssociatedServiceParam param){

        Optional<AssocietadService> associatedServiceOpt =  associatedRepository.findById(code);
        AssocietadService associatedService;
        if(associatedServiceOpt.isPresent()){
            associatedService = associatedServiceOpt.get();
        } else {
            throw new RuntimeException("no existe el servicio");
        }

        Integer actualParam = findParamByName(name, associatedService.getParams());  
        if(actualParam >= 0){

            associatedService.getParams().get(actualParam).name = param.name;
            associatedService.getParams().get(actualParam).valueType = param.valueType;
            this.associatedRepository.save(associatedService);
        }  else {
            throw new RuntimeException("no existe el parametro");
        }    
    }

    public Optional<AssocietadService> findByCode(String code){
       return this.associatedRepository.findById(code);
    }

    public Integer findParamByName(String name, List<AssociatedServiceParam> params){
        int index = 0;
        for(AssociatedServiceParam param : params){
            if(param.getName().equals(name)) return index;
            index++;
        }
        return -1;
    }

 

    public void addParam (String id, AssociatedServiceParam param){

        Optional<AssocietadService> associatedId = this.associatedRepository.findById(id);
        if (!associatedId.isPresent()){
            throw new RuntimeException("no existe el servicio asociado");
        }else{
            if (associatedId.get().getParams()== null){
                List<AssociatedServiceParam> listParam= new ArrayList<>();
                listParam.add(param);
                associatedId.get().setParams(listParam);
            }else{
                associatedId.get().getParams().add(param);
               
            }
        }
        associatedRepository.save(associatedId.get());
    }
}
