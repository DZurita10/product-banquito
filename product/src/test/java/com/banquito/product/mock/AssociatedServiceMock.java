package com.banquito.product.mock;

import java.util.ArrayList;
import java.util.List;

import com.banquito.product.associated_service.controller.dto.ParamRQ;
import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;
import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;

public class AssociatedServiceMock {
    
    public List<ParamRQ> mockListParamRQ() {
        List<ParamRQ> params = new ArrayList<>();
        params.add(new ParamRQ("Parámetro", "Valor"));
        return params;
    }

    public AssocietadService mockAssocietadService(List<AssociatedServiceParam> serviceParams) {
        String serviceName = "Servicio";
        AssocietadService service = new AssocietadService();
        service.setName(serviceName);
        service.setParams(serviceParams);
        service.setId("Id159");
        return service;
    }

    public AssociatedServiceParam mockAssociatedServiceParam(String name, String valueType) {
        List<AccountAssociatedServiceParam> accountParams = new ArrayList<>();
        AssociatedServiceParam param = new AssociatedServiceParam();
        param.setName(name);
        param.setAccount(accountParams);
        param.setValueType(valueType);
        return param;
    }

    public List<AssociatedServiceParam> mockListAssociatedServiceParam(AssociatedServiceParam param) {
        List<AssociatedServiceParam> serviceParams = new ArrayList<>();
        serviceParams.add(param);
        return serviceParams;
    }

    public AssocietadService mockAssocietedServiceAccount(List<AssociatedServiceParam> serviceParams) {
        String serviceName = "Servicio";
        List<AccountAssociatedServiceParam> accounts = new ArrayList<>();
        AssocietadService service = new AssocietadService();
        service.setName(serviceName);
        service.setParams(serviceParams);
        service.setAccounts(accounts);
        service.setId("Id159");
        return service;
    }
}
