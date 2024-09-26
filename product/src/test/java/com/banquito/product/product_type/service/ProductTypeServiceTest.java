package com.banquito.product.product_type.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.mock.ProductTypeMock;
import com.banquito.product.product.model.ProductType;
import com.banquito.product.product.repository.ProductTypeRepository;
import com.banquito.product.product.service.ProductTypeService;

@SpringBootTest
public class ProductTypeServiceTest {
    @Mock
    private ProductTypeRepository productTypeRepository; 
    
    @InjectMocks
    private ProductTypeService productTypeService; 
    
    @Test
    public void testFindAll(){
        List<ProductType> expect = ProductTypeMock.mockListOfProductType(); 
        when(this.productTypeRepository.findAll()).thenReturn(expect);

        List<ProductType> response = this.productTypeService.findAll();
        assertEquals(expect, response);
    }

    @Test 
    public void testFindById(){
        String id = "123";
        ProductType expect = ProductTypeMock.mockProductType();
        when(this.productTypeRepository.findById(id)).thenReturn(expect);

        ProductType response = this.productTypeService.findById(id);
        assertEquals(expect, response);
    }

    @Test
    public void testFindByName(){
        String name = "Test";
        ProductType expect = ProductTypeMock.mockProductType();
        when(this.productTypeRepository.findByName(name)).thenReturn(expect);

        ProductType response = this.productTypeService.findByName(name);
        assertEquals(expect, response);
    }
}
