package com.banquito.product.associated_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.associated_service.controller.dto.ParamRQ;
import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;
import com.banquito.product.associated_service.model.AssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;
import com.banquito.product.mock.AssociatedServiceMock;

@SpringBootTest
public class AssociatedServiceServiceTest {

	@Mock
	private AssocietadServiceRepository associatedServiceRepository;

	@InjectMocks
	private AssocietadServiceService associatedServiceService;

	@Test
	public void testSetAccountServiceParams() {
		String accountNum = "24389746";
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		List<ParamRQ> params = associatedServiceMock.mockListParamRQ();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService service = associatedServiceMock.mockAssocietadService(serviceParams);
		when(associatedServiceRepository.findByName(service.getName())).thenReturn(Arrays.asList(service));

		associatedServiceService.setAccountServiceParams(service.getName(), params, accountNum);

		verify(associatedServiceRepository).save(service);
		assertEquals(1, param.getAccount().size());
		AccountAssociatedServiceParam actualAccountParam = param.getAccount().get(0);
		assertEquals(accountNum, actualAccountParam.getCodeAccount());
		assertEquals("ACT", actualAccountParam.getStatus());
		assertEquals("Valor", actualAccountParam.getTextValue());
	}

	@Test
	public void testVincularParam() {
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService service = associatedServiceMock.mockAssocietadService(serviceParams);
		when(associatedServiceRepository.findByName(service.getName())).thenReturn(Arrays.asList(service));

		associatedServiceService.vincularParam(service.getName(), param);

		verify(associatedServiceRepository).save(service);
		assertEquals(2, serviceParams.size());
		AssociatedServiceParam firstParam = serviceParams.get(0);
		assertEquals(param.getName(), firstParam.getName());
	}

	@Test
	public void testCreateAssociatedServiceParam() {
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService service = associatedServiceMock.mockAssocietadService(serviceParams);
		ArgumentCaptor<AssocietadService> argument = ArgumentCaptor.forClass(AssocietadService.class);

		associatedServiceService.createAssociatedServiceParam(service);

		verify(associatedServiceRepository, times(1)).save(argument.capture());
		assertEquals(service, argument.getValue());
	}

	@Test
	public void testUpdateServiceAssoParam() {
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService service = associatedServiceMock.mockAssocietadService(serviceParams);
		AssociatedServiceParam updatedParam = associatedServiceMock.mockAssociatedServiceParam(
				"Nuevo parámetro", "Nuevo tipo de valor");
		when(associatedServiceRepository.findById(service.getId())).thenReturn(Optional.of(service));

		associatedServiceService.updateServiceAssoParam(service.getId(), param.getName(), updatedParam);

		verify(associatedServiceRepository, times(1)).findById(service.getId());
		verify(associatedServiceRepository, times(1)).save(service);
		assertEquals(updatedParam.getValueType(), service.getParams().get(0).getValueType());
	}

	@Test
	public void testFindByCode() {
		String code = "Id159";
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService expectedService = associatedServiceMock.mockAssocietadService(serviceParams);
		when(associatedServiceRepository.findById(code)).thenReturn(Optional.of(expectedService));
		Optional<AssocietadService> actualService = associatedServiceService.findByCode(code);
		verify(associatedServiceRepository).findById(code);
		assertTrue(actualService.isPresent());
		assertEquals(expectedService, actualService.get());
	}

	@Test
	public void testFindByCode_NotFound() {
		String code = "NotExistingId";
		when(associatedServiceRepository.findById(code)).thenReturn(Optional.empty());
		Optional<AssocietadService> actualService = associatedServiceService.findByCode(code);
		verify(associatedServiceRepository).findById(code);
		assertFalse(actualService.isPresent());
	}

	@Test
	public void testAddParam() {
		String id = "1";
		AssociatedServiceParam param = new AssociatedServiceParam();
		AssocietadService associatedService = new AssocietadService();
		associatedService.setId(id);
		when(associatedServiceRepository.findById(id)).thenReturn(Optional.of(associatedService));
		associatedServiceService.addParam(id, param);
		verify(associatedServiceRepository).save(associatedService);
		assertEquals(1, associatedService.getParams().size());
		AssociatedServiceParam firstParam = associatedService.getParams().get(0);
		assertEquals(param, firstParam);
	}

	@Test
	public void testAddParam_notFound() {
		String id = "1";
		AssociatedServiceParam param = new AssociatedServiceParam();
		when(associatedServiceRepository.findById(id)).thenReturn(Optional.empty());
		try {
			associatedServiceService.addParam(id, param);
			fail();
		} catch (RuntimeException e) {
			assertEquals("no existe el servicio asociado", e.getMessage());
		}
	}

	@Test
	public void testAddAccount() {
		String id = "1";
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AccountAssociatedServiceParam> listAccount = new ArrayList<>();
		listAccount.add(new AccountAssociatedServiceParam());
		param.setAccount(listAccount);
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService service = associatedServiceMock.mockAssocietadService(serviceParams);
		when(associatedServiceRepository.findById(id)).thenReturn(Optional.of(service));
		associatedServiceService.addAccount(id, param);
		verify(associatedServiceRepository).save(service);
		assertEquals(2, param.getAccount().size());
		AccountAssociatedServiceParam actualAccountParam = param.getAccount().get(1);
		assertEquals(null, actualAccountParam.getCodeAccount());
		assertEquals(null, actualAccountParam.getStatus());
		assertEquals(null, actualAccountParam.getTextValue());
	}

	@Test
	public void testAddAccount_ServiceNotFound() {
		String id = "1";
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		when(associatedServiceRepository.findById(id)).thenReturn(Optional.empty());
		associatedServiceService.addAccount(id, param);
	}

	@Test
	public void testFindAllAssociatedServices() {
		List<AssocietadService> expectedServices = new ArrayList<>();
		AssocietadService service1 = new AssocietadService();
		service1.setName("Servicio 1");
		service1.setId("Id001");
		expectedServices.add(service1);
		AssocietadService service2 = new AssocietadService();
		service2.setName("Servicio 2");
		service2.setId("Id002");
		expectedServices.add(service2);

		when(associatedServiceRepository.findAll()).thenReturn(expectedServices);

		List<AssocietadService> actualServices = associatedServiceService.findAllAssociatedServices();

		verify(associatedServiceRepository, times(1)).findAll();
		assertEquals(expectedServices, actualServices);
	}

	@Test
	public void testCrearAssociatedService() {
		AssociatedServiceMock associatedServiceMock = new AssociatedServiceMock();
		AssociatedServiceParam param = associatedServiceMock.mockAssociatedServiceParam("Parámetro", "Tipo de valor");
		List<AssociatedServiceParam> serviceParams = associatedServiceMock.mockListAssociatedServiceParam(param);
		AssocietadService service = associatedServiceMock.mockAssocietedServiceAccount(serviceParams);
		ArgumentCaptor<AssocietadService> argument = ArgumentCaptor.forClass(AssocietadService.class);

		associatedServiceService.crearAssociatedService(service);

		verify(associatedServiceRepository, times(1)).save(argument.capture());
		AssocietadService savedService = argument.getValue();
		assertEquals(service, savedService);
		assertEquals(service.getAccounts(), savedService.getAccounts());
	}

	@Test
public void testFindParamsByServiceName() {
    String serviceName = "Servicio 1";
    AssociatedServiceParam param1 = new AssociatedServiceParam();
    param1.setName("Param 1");
    AssociatedServiceParam param2 = new AssociatedServiceParam();
    param2.setName("Param 2");
    List<AssociatedServiceParam> expectedParams = Arrays.asList(param1, param2);
    AssocietadService expectedService = new AssocietadService();
    expectedService.setName(serviceName);
    expectedService.setParams(expectedParams);
    List<AssocietadService> expectedServices = Arrays.asList(expectedService);

    when(associatedServiceRepository.findByName(serviceName)).thenReturn(expectedServices);

    List<AssociatedServiceParam> actualParams = associatedServiceService.findParamsByServiceName(serviceName);

    assertEquals(expectedParams, actualParams);
    verify(associatedServiceRepository, times(1)).findByName(serviceName);
}
}
