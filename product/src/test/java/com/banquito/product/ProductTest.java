package com.banquito.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.product.controller.dto.request.ProductRQ;
import com.banquito.product.product.controller.mapper.ProductMapperSave;
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
public class ProductTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenListOfProducts_whenFindAllProducts_thenReturnListOfProducts() throws Exception {
        // given
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().id("123456").name("Ahorro Programado").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build());
        productList.add(Product.builder().id("123457").name("Ahorro Programado").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build());

        given(this.productService.findAll()).willReturn(productList);
        // when
        ResultActions response = this.mockMvc.perform(get("/api/products/products"));

        // then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(productList.size())));
    }

    @Test
    public void givenProductId_whenFindProductById_thenReturnProduct() throws Exception {
        // given
        String _id = "123456";
        Product product = Product.builder()
                .id("123456").name("Ahorro Programado").status("Activo")
                .startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build();

        given(this.productService.findById(_id))
                .willReturn(product);
        // when
        ResultActions response = this.mockMvc.perform(get("/api/products/id-product/{id}", _id));

        // then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(product.getId())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.status", is(product.getStatus())));
    }

    @Test
    public void givenProductName_whenFindProductByName_thenReturnProduct() throws Exception {
        // given
        String name = "Ahorro Programado";
        Product product = Product.builder()
                .id("123456").name("Ahorro Programado").status("Activo")
                .startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build();

        given(this.productService.findByName(name))
                .willReturn(product);

        // when
        ResultActions response = this.mockMvc.perform(get("/api/products/name-product/{name}", name));

        // then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(product.getId())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.status", is(product.getStatus())));

    }

    @Test
    public void givenListOfProducts_whenFindProductsByStatus_thenReturnListOfProducts() throws Exception {
        // given
        String status = "Activo";
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().id("123456").name("Ahorro Programado").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build());
        productList
                .add(Product.builder().id("123457").name("Ahorro Programado").status("Inactivo").startDate(new Date())
                        .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                        .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                        .associatedService(null).productType(null).build());
        productList
                .add(Product.builder().id("123458").name("Ahorro Programado").status("Inactivo").startDate(new Date())
                        .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                        .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                        .associatedService(null).productType(null).build());

        given(this.productService.findByStatus(status))
                .willReturn(productList);

        // when
        ResultActions response = this.mockMvc.perform(get("/api/products/status-product/{status}", status));

        // then

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].id", is(productList.get(0).getId())))
                .andExpect(jsonPath("$[0].name", is(productList.get(0).getName())))
                .andExpect(jsonPath("$[0].status", is(productList.get(0).getStatus())));

    }

    @Test
    public void givenProductObject_whenSaveProduct_thenReturnOk() throws Exception {
        // given
        ProductRQ productRQ = ProductRQ.builder().name("Ahorro Ejemplo").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESO").useCheckbook("Y").allowTransference("Y")
                .typeClient("BUSINESS")
                .minOpeningBalance("0")
                .interestRate(null)
                .associatedService(null)
                .productType(null).build();

        ProductMapperSave productMapperSave = new ProductMapperSave();
        given(this.productService.saveProduct(productMapperSave.toProduct(productRQ)))
                .willReturn(ResponseEntity.ok(""));

        // when
        ResultActions response = this.mockMvc.perform(post("/api/products/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsBytes(productRQ)));

        // then
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenProductObjectAndStatus_whenUpdateProduct_thenReturnOk() throws Exception {
        // given
        String status = "Inactivo";
        ProductRQ productRQ = ProductRQ.builder().name("Ahorro Ejemplo").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESO").useCheckbook("Y").allowTransference("Y")
                .typeClient("BUSINESS")
                .minOpeningBalance("0")
                .interestRate(null)
                .associatedService(null)
                .productType(null).build();

        ProductMapperSave productMapperSave = new ProductMapperSave();
        given(this.productService.updateProduct(status, productMapperSave.toProduct(productRQ)))
                .willReturn(ResponseEntity.ok(""));

        // when
        ResultActions response = this.mockMvc.perform(put("/api/products/product/{status}", status)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsBytes(productRQ)));

        // then
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenProductObject_whenValidateProduct_thenReturnOk() throws Exception {
        // // given
        // String status = "Inactivo";
        // ProductRQ productRQ = ProductRQ.builder().name("Ahorro
        // Ejemplo").status("Activo").startDate(new Date())
        // .endDate(new
        // Date()).temporalyAccountState("PROCESO").useCheckbook("Y").allowTransference("Y")
        // .typeClient("BUSINESS")
        // .minOpeningBalance("0")
        // .interestRate(null)
        // .associatedService(null)
        // .productType(null).build();

        // ProductMapperSave productMapperSave = new ProductMapperSave();
        // given(this.productService.updateProduct(status,
        // productMapperSave.toProduct(productRQ)))
        // .willReturn(ResponseEntity.ok(""));

        // // when
        // ResultActions response =
        // this.mockMvc.perform(put("/api/products/product/{status}", status)
        // .contentType(MediaType.APPLICATION_JSON)
        // .content(this.objectMapper.writeValueAsBytes(productRQ)));

        // // then
        // response.andDo(print())
        // .andExpect(status().isOk());
    }

    @Test
    public void givenListOfProductsAndListOfAssociatedServiceProduct_whenLinkAssociateProduct_thenReturnOk() throws Exception {
        // given
        List<Product> productList = new ArrayList<>();
        List<AssociatedServiceProduct> associateServiceList = new ArrayList<>();
        productList.add(Product.builder().id("123456").name("Ahorro Programado").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build());
        productList.add(Product.builder().id("123457").name("Ahorro Programado").status("Activo").startDate(new Date())
                .endDate(new Date()).temporalyAccountState("PROCESS").useCheckbook("N").allowTransference("Y")
                .typeClient("BUSINESS").minOpeningBalance("2000").interestRate(null)
                .associatedService(null).productType(null).build());

        associateServiceList.add(AssociatedServiceProduct.builder().id("12345").name("Aso Serv Sample")
                .allowPayment("Y").paymentMethod("CASH")
                .chargeVat("Y").fee(0.0).build());

        associateServiceList.add(AssociatedServiceProduct.builder().id("12346").name("Aso Serv Sample")
                .allowPayment("Y").paymentMethod("CASH")
                .chargeVat("Y").fee(0.0).build());

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("products", productList);
        json.put("associatedServices", associateServiceList);

        // given(this.productService.linkAssociatedServices(productList, associateServiceList));

        // when
        ResultActions response = this.mockMvc.perform(put("/api/products/product-link-service")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsBytes(json)));

        // then
        response.andDo(print())
                .andExpect(status().isOk());
    }
}
