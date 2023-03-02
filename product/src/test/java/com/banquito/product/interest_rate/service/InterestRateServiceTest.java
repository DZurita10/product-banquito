package com.banquito.product.interest_rate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.mock.InterestRateMock;
import com.banquito.product.product.model.InterestRate;
import com.banquito.product.product.repository.InterestRateRepository;
import com.banquito.product.product.service.InterestRateService;

@SpringBootTest
public class InterestRateServiceTest {

	@Mock
	private InterestRateRepository interestRateRepository;

	@InjectMocks
	private InterestRateService interestRateService;

	@Test
	public void testFindAll() {
		InterestRateMock interestRateMock = new InterestRateMock();
		InterestRate interestRateMock1 = interestRateMock.mockInterestRate("1", "InterestRate1", "Fixed");
		InterestRate interestRateMock2 = interestRateMock.mockInterestRate("2", "InterestRate2", "Variable");

		List<InterestRate> expectedInterestRates = Arrays.asList(interestRateMock1, interestRateMock2);
		when(interestRateRepository.findAll()).thenReturn(expectedInterestRates);
		List<InterestRate> actualInterestRates = interestRateService.findAll();
		assertEquals(expectedInterestRates, actualInterestRates);
	}

}
