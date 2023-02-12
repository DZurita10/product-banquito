package com.banquito.product.associated_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

}
