package com.banquito.product.request_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;
import com.banquito.product.request_service.model.RequestService;
import com.banquito.product.request_service.repository.RequestServiceRepository;
import com.banquito.product.request_service.service.RequestServiceService;

@SpringBootTest
public class RequestServiceTest {
    @Mock
    private RequestServiceRepository requestServiceRepository;

    @InjectMocks
    private RequestServiceService requestServiceService;

    @Mock
    private AssocietadServiceRepository associetadServiceRepository;

    @Mock
    private RequestService requestService;

    @Test
    public void testGetRequestService_WhenRequestServiceExists() {
        // Given
        String codeRequest = "Code123";
        RequestService expectedRequestService = new RequestService();
        when(requestServiceRepository.findByCodeRequest(codeRequest))
                .thenReturn(Optional.of(expectedRequestService));

        // When
        RequestService actualRequestService = requestServiceService.getRequestAssociatedService(codeRequest);

        // Then
        verify(requestServiceRepository).findByCodeRequest(codeRequest);
        assertNotNull(actualRequestService);
        assertEquals(expectedRequestService, actualRequestService);
    }

    @Test
    public void testGetRequestService_WhenRequestServiceDoesNotExist() {
        // Given
        String codeRequest = "Code123";
        when(requestServiceRepository.findByCodeRequest(codeRequest))
                .thenReturn(Optional.empty());

        // When & Then
        Exception exception = assertThrows(RuntimeException.class,
                () -> requestServiceService.getRequestAssociatedService(codeRequest));
        assertEquals("La solicitud no existe", exception.getMessage());
    }

    @Test
    public void testSaveRequestService() {
        RequestService requestService = new RequestService();
        requestService.setNameAssociatedService("Servicio asociado");

        AssocietadService associetadService = new AssocietadService();
        associetadService.setName("Servicio asociado");

        List<AssocietadService> associatedServices = new ArrayList<>();
        associatedServices.add(associetadService);

        when(associetadServiceRepository.findByName(requestService.getNameAssociatedService()))
                .thenReturn(associatedServices);
        when(requestServiceRepository.save(requestService)).thenReturn(requestService);

        RequestService savedRequestService = requestServiceService.saveRequestService(requestService);

        verify(associetadServiceRepository).findByName(requestService.getNameAssociatedService());
        verify(requestServiceRepository).save(requestService);

        assertNotNull(savedRequestService);
        assertEquals(requestService, savedRequestService);
    }

    @Test
    public void testFindAll() {
        List<RequestService> expectedRequests = Arrays.asList(new RequestService(), new RequestService());
        when(requestServiceRepository.findAll()).thenReturn(expectedRequests);
        List<RequestService> actualRequests = requestServiceService.findAll();
        verify(requestServiceRepository).findAll();
        assertEquals(expectedRequests, actualRequests);
    }
}
