package com.banquito.product.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.banquito.product.product.model.AssociatedServiceProduct;

public class AssociatedServiceServiceProductMock {

    public static AssociatedServiceProduct mockAssociatedService(Optional<String> id, Optional<String> name) {
        AssociatedServiceProduct associatedService = AssociatedServiceProduct.builder()
                .id(!id.isPresent() ? "12345" : id.get())
                .name(!name.isPresent() ? "Aso Serv Sample" : name.get())
                .allowPayment("Y")
                .paymentMethod("CASH")
                .chargeVat("Y")
                .fee(0.0).build();

        return associatedService;
    }

    public static List<AssociatedServiceProduct> mockListOfAssociatedService() {
        List<AssociatedServiceProduct> associatedServices = new ArrayList<>();
        associatedServices.add(mockAssociatedService(Optional.of("12345"), Optional.empty()));
        associatedServices.add(mockAssociatedService(Optional.of("12346"), Optional.empty()));
        associatedServices.add(mockAssociatedService(Optional.of("12347"), Optional.empty()));
        associatedServices.add(mockAssociatedService(Optional.of("12348"), Optional.empty()));
        associatedServices.add(mockAssociatedService(Optional.of("12349"), Optional.empty()));
        return associatedServices;
    }
}
