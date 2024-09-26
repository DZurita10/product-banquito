package com.banquito.product.product.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.product.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository; 
    
    @InjectMocks
    private ProductService productService; 

    @Test
    public void testRulesToLink(){
        //given 
        //when 
        //then
    }
}
