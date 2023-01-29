package com.banquito.product.request_service.controller.mapper;

import com.banquito.product.request_service.controller.dto.RequestServiceRQ;
import com.banquito.product.request_service.controller.dto.RequestServiceRS;
import com.banquito.product.request_service.model.RequestService;

public class RequestServiceMapper {
    public static RequestService map(RequestServiceRQ requestServiceRQ) {

        return RequestService.builder()
                .accountNumber(requestServiceRQ.getAccountNumber())
                .fullName(requestServiceRQ.getFullName())
                .nameAssociatedService(requestServiceRQ.getNameAssociatedService()).build();

    }

    public static RequestServiceRS map(RequestService requestService) {

        return RequestServiceRS.builder()
                .codeRequest(requestService.getCodeRequest())
                .status(requestService.getStatus())
                .startDate(requestService.getStartDate()).build();
    }
}
