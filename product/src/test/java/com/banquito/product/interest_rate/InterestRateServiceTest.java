package com.banquito.product.interest_rate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.mock.InterestRateMock;
import com.banquito.product.product.repository.InterestRateRepository;
import com.banquito.product.product.service.InterestRateService;

@SpringBootTest
public class InterestRateServiceTest {

    @Mock
    private InterestRateRepository interestRateRepository;

    @InjectMocks
    private InterestRateService interestRateService;

    @Test
    public void testFindById() {
        String id = "Id159";
        InterestRateMock interestRateMock = new InterestRateMock();

    }
}
