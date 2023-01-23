package com.banquito.product.product.controller.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.banquito.product.product.controller.dto.request.InterestRateRQ;
import com.banquito.product.product.controller.dto.request.InterestRateStatusRQ;
import com.banquito.product.product.controller.dto.response.InterestRateProductRS;
import com.banquito.product.product.controller.dto.response.InterestRateRS;
import com.banquito.product.product.controller.dto.response.InterestRateReportRS;
import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.model.InterestRateLog;

public class InterestRateMapper {

    public static InterestRate mapToInterestRate(InterestRateRQ interestRateRQ) {
        List<InterestRateLog> interestRateLogs = new ArrayList<>();
        interestRateLogs.add(InterestRateLog.builder()
                .value(interestRateRQ.getValue())
                .build());
        return InterestRate.builder()
                .id(interestRateRQ.getId())
                .interestRateLogs(interestRateLogs)
                .build();
    }

    public static InterestRateProductRS mapToInterestRateProductRS(InterestRate interestRate) {
        return InterestRateProductRS.builder()
                .id(interestRate.getId())
                .name(interestRate.getName())
                .value(interestRate.getInterestRateLogs().get(interestRate.getInterestRateLogs().size() - 1).getValue())
                .calcBase(interestRate.getCalcBase())
                .build();
    }

    public static InterestRateRS mapToInterestRateRS(InterestRate interestRate) {
        return InterestRateRS.builder()
                .id(interestRate.getId())
                .name(interestRate.getName())
                .build();
    }

    public static InterestRateReportRS mapToInterestRateReportRS(InterestRate interestRate) {
        BigDecimal interestValue = null;
        String interestStatus = null;
        if (interestRate.getInterestRateLogs() != null && interestRate.getInterestRateLogs().size() > 0) {
            interestValue = interestRate.getInterestRateLogs().get(interestRate.getInterestRateLogs().size() - 1)
                    .getValue();
            interestStatus = interestRate.getInterestRateLogs().get(interestRate.getInterestRateLogs().size() - 1)
                    .getStatus();
        }

        return InterestRateReportRS.builder()
                .id(interestRate.getId())
                .name(interestRate.getName())
                .type(interestRate.getType())
                .value(interestValue)
                .calcBase(interestRate.getCalcBase())
                .status(interestStatus)
                .build();
    }

    public static InterestRate interestRateStatusRQmapToInterestRate(InterestRateStatusRQ interestRateStatusRQ) {

        List<InterestRateLog> interestRateLogs = new ArrayList<>();
        interestRateLogs.add(InterestRateLog.builder()
                .status(interestRateStatusRQ.getStatus())
                .build());

        return InterestRate.builder()
                .id(interestRateStatusRQ.getId())
                .interestRateLogs(interestRateLogs)
                .build();
    }
}
