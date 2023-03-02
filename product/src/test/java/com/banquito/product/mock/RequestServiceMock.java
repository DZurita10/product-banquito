package com.banquito.product.mock;

import com.banquito.product.request_service.model.RequestService;

public class RequestServiceMock {

    public RequestService mockRequestService(String name, String accountNumber) {

        RequestService param = new RequestService();
        param.setFullName(name);
        param.setAccountNumber(accountNumber);
        return param;
    }
}
