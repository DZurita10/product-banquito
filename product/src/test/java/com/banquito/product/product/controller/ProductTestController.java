package com.banquito.product.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.banquito.product.mock.AssociatedServiceServiceProductMock;
import com.banquito.product.mock.ProductServiceMock;
import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.model.AssociatedServiceProduct;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.service.ProductService;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductTestController {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ProductService productService;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        public void givenListOfProducts_whenFindAllProducts_thenReturnListOfProducts() throws Exception {
                List<Product> mocked = ProductServiceMock.mockListOfProducts();
                when(this.productService.findAll()).thenReturn(mocked);

                ResultActions response = this.mockMvc.perform(get("/api/products/products"));

                response.andExpect(status().isOk())
                                .andDo(print())
                                .andExpect(jsonPath("$.size()", is(mocked.size())));
        }

        // @Test
        // public void givenProductId_whenFindProductById_thenReturnProduct() throws
        // Exception {
        // String _id = "123456";
        // Product mocked = ProductServiceMock.mockProduct(Optional.empty(),
        // Optional.empty(), Optional.empty());
        // Product expected = ProductServiceMock.mockProduct(Optional.empty(),
        // Optional.empty(), Optional.empty());
        // when(this.productService.findById(any(String.class))).thenReturn(mocked);

        // ResultActions response =
        // this.mockMvc.perform(get("/api/products/id-product/{id}", _id));

        // response.andExpect(status().isOk())
        // .andDo(print())
        // .andExpect(jsonPath("$.id", is(expected.getId())))
        // .andExpect(jsonPath("$.name", is(expected.getName())))
        // .andExpect(jsonPath("$.status", is(expected.getStatus())));
        // }

        // @Test
        // public void givenProductName_whenFindProductByName_thenReturnProduct() throws
        // Exception {
        // String name = "Ahorro Programado";
        // Product mocked = ProductServiceMock.mockProduct(Optional.empty(),
        // Optional.empty(), Optional.empty());
        // Product expected = ProductServiceMock.mockProduct(Optional.empty(),
        // Optional.empty(), Optional.empty());
        // when(this.productService.findByName(any(String.class))).thenReturn(mocked);

        // ResultActions response =
        // this.mockMvc.perform(get("/api/products/name-product/{name}", name));

        // response.andExpect(status().isOk())
        // .andDo(print())
        // .andExpect(jsonPath("$.id", is(expected.getId())))
        // .andExpect(jsonPath("$.name", is(expected.getName())))
        // .andExpect(jsonPath("$.status", is(expected.getStatus())));

        // }

        // @Test
        // public void
        // givenListOfProducts_whenFindProductsByStatus_thenReturnListOfProducts()
        // throws Exception {
        // String status = "Activo";
        // List<Product> mocked = ProductServiceMock.mockListOfProducts();
        // List<Product> expected = ProductServiceMock.mockListOfProducts();
        // when(this.productService.findByStatus(any(String.class))).thenReturn(mocked);

        // ResultActions response =
        // this.mockMvc.perform(get("/api/products/status-product/{status}", status));

        // response.andExpect(status().isOk())
        // .andDo(print())
        // .andExpect(jsonPath("$[0].id", is(expected.get(0).getId())))
        // .andExpect(jsonPath("$[0].name", is(expected.get(0).getName())))
        // .andExpect(jsonPath("$[0].status", is(expected.get(0).getStatus())));

        // }

        @Test
        public void givenProductObject_whenSaveProduct_thenReturnOk() throws Exception {
                ResponseEntity<String> mocked = ResponseEntity.ok("");
                when(this.productService.saveProduct(any(Product.class))).thenReturn(mocked);

                ResultActions response = this.mockMvc.perform(post("/api/products/product")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsBytes(ProductServiceMock.mockProductRQ())));

                response.andDo(print())
                                .andExpect(status().isOk());
        }

        // @Test
        // public void givenProductObjectAndStatus_whenUpdateProduct_thenReturnOk()
        // throws Exception {
        // // given
        // String status = "Inactivo";
        // ProductRQ productRQ = ProductServiceMock.mockProductRQ();
        // ResponseEntity<String> mocked = ResponseEntity.ok("");

        // given(this.productService.updateProduct(any(String.class),
        // any(Product.class)))
        // .willReturn(mocked);

        // // when
        // ResultActions response =
        // this.mockMvc.perform(put("/api/products/product/{status}", status)
        // .contentType(MediaType.APPLICATION_JSON)
        // .content(this.objectMapper.writeValueAsBytes(productRQ)));

        // // then
        // response.andDo(print())
        // .andExpect(status().isOk());
        // }

        @Test
        public void givenListOfProductsAndListOfAssociatedServiceProduct_whenLinkAssociateProduct_thenReturnOk()
                        throws Exception {
                List<Product> productList = ProductServiceMock.mockListOfProducts();
                List<AssociatedServiceProduct> associateServiceList = AssociatedServiceServiceProductMock
                                .mockListOfAssociatedService();

                Map<String, Object> json = new HashMap<String, Object>();
                json.put("products", productList);
                json.put("associatedServices", associateServiceList);

                ResultActions response = this.mockMvc.perform(put("/api/products/product-link-service")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsBytes(json)));

                response.andDo(print())
                                .andExpect(status().isOk());
        }
}
