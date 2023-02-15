package com.banquito.product.associated_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.product.associated_service.controller.dto.ParamRQ;
import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;
import com.banquito.product.associated_service.model.AssociatedServiceParam;
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

    public List<AssociatedServiceParam> findParamsByServiceName(String name) {
        List<AssocietadService> service = this.associatedRepository.findByName(name);
        return service.get(0).getParams();
    }

    public void setAccountServiceParams(String serviceName, List<ParamRQ> params, String accountNum) {
        /*
         * System.out.println("el id>");
         * System.out.println(serviceId);
         * System.out.println("el account>");
         * System.out.println(accountNum);
         * System.out.println("el params>");
         * System.out.println(params.get(0).getValue().getClass());
         */
        List<AssocietadService> serviceOpt = this.associatedRepository.findByName(serviceName);
        if (serviceOpt == null)
            throw new RuntimeException("No existe el servicio asociado");
        else {
            AssocietadService service = serviceOpt.get(0);
            List<AssociatedServiceParam> listParams = service.getParams();
            List<AccountAssociatedServiceParam> actualAccountsParams;
            AccountAssociatedServiceParam accountParam;
            for (ParamRQ paramRQ : params) {
                for (AssociatedServiceParam param : listParams) {
                    if (paramRQ.getName().equals(param.name)) {
                        accountParam = new AccountAssociatedServiceParam(accountNum, "ACT", paramRQ.getValue(), null,
                                null, null, null);
                        actualAccountsParams = param.getAccount();
                        actualAccountsParams.add(accountParam);
                        param.setAccount(actualAccountsParams);
                        // break;
                    }
                }
            }
            service.setParams(listParams);
            try {
                this.associatedRepository.save(service);
            } catch (Exception e) {
                throw new RuntimeException("error guardando el producto: " + e);
            }
        }
    }

    public void vincularParam(String name, AssociatedServiceParam param) {
        AssocietadService associetadService = this.associatedRepository.findByName(name).get(0);
        List<AssociatedServiceParam> auxList = associetadService.getParams();
        auxList.add(param);
        associetadService.setParams(auxList);
        this.associatedRepository.save(associetadService);

    }

    public void createAssociatedServiceParam(AssocietadService param) {
        try {
            this.associatedRepository.save(param);
        } catch (Exception e) {
            new RuntimeException("Problemas al guardar el servicio asociado:" + e);
        }
    }

    public void updateServiceAssoParam(String code, String name, AssociatedServiceParam param) {

        Optional<AssocietadService> associatedServiceOpt = associatedRepository.findById(code);
        AssocietadService associatedService;
        if (associatedServiceOpt.isPresent()) {
            associatedService = associatedServiceOpt.get();
        } else {
            throw new RuntimeException("no existe el servicio");
        }

        Integer actualParam = findParamByName(name, associatedService.getParams());
        if (actualParam >= 0) {

            associatedService.getParams().get(actualParam).name = param.name;
            associatedService.getParams().get(actualParam).valueType = param.valueType;
            this.associatedRepository.save(associatedService);
        } else {
            throw new RuntimeException("no existe el parametro");
        }
    }

    public Optional<AssocietadService> findByCode(String code) {
        return this.associatedRepository.findById(code);
    }

    public Integer findParamByName(String name, List<AssociatedServiceParam> params) {
        int index = 0;
        for (AssociatedServiceParam param : params) {
            if (param.getName().equals(name))
                return index;
            index++;
        }
        return -1;
    }

    public void addParam(String id, AssociatedServiceParam param) {

        Optional<AssocietadService> associatedId = this.associatedRepository.findById(id);
        if (!associatedId.isPresent()) {
            throw new RuntimeException("no existe el servicio asociado");
        } else {
            if (associatedId.get().getParams() == null) {
                List<AssociatedServiceParam> listParam = new ArrayList<>();
                listParam.add(param);
                associatedId.get().setParams(listParam);
            } else {
                associatedId.get().getParams().add(param);

            }
        }
        associatedRepository.save(associatedId.get());
    }

    public void addAccount(String id, AssociatedServiceParam param) {
        System.err.println("id: " + id);
        System.err.println("param: " + param);
        try {
            Optional<AssocietadService> associatedId = this.associatedRepository.findById(id);
            if (!associatedId.isPresent()) {
                throw new RuntimeException("no existe el servicio asociado");
            } else {

                associatedId.get().getParams().forEach(params -> {

                    if (params.getName().equals(param.getName())) {
                        System.err.println("entro");

                        if (params.getAccount() == null) {
                            System.err.println("entro2");
                            List<AccountAssociatedServiceParam> listAccount = new ArrayList<>();
                            for (AccountAssociatedServiceParam paramAux : param.getAccount()) {
                                listAccount.add(paramAux);
                            }
                            // listAccount.add(param.getAccount().get(0));
                            params.setAccount(listAccount);
                        } else {
                            System.err.println("entro3");
                            params.getAccount().add(param.getAccount().get(0));
                        }
                        System.err.println("params: " + params.getAccount());

                    }
                });
            }

            associatedRepository.save(associatedId.get());
        } catch (Exception e) {
            System.err.println("error: " + e);
        }

    }

}
