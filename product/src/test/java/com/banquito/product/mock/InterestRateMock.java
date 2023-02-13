package com.banquito.product.mock;

import java.util.ArrayList;
import java.util.List;

import com.banquito.product.associated_service.controller.dto.ParamRQ;

public class InterestRateMock {

    public List<ParamRQ> mockListParamRQ() {
        List<ParamRQ> params = new ArrayList<>();
        params.add(new ParamRQ("Parámetro", "Valor"));
        return params;
    }
}
