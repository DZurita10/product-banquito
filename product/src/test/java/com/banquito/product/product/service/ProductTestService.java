package com.banquito.product.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.mock.ProductServiceMock;
import com.banquito.product.mock.AssociatedServiceServiceProductMock;
import com.banquito.product.product.model.AssociatedServiceProduct;
import com.banquito.product.product.model.Product;
import com.banquito.product.product.repository.ProductRepository;

@SpringBootTest
public class ProductTestService {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void givenListOfProducts_whenFindAllProducts_thenReturnListOfProducts() {
        List<Product> products = ProductServiceMock.mockListOfProducts();
        when(this.productRepository.findAll()).thenReturn(products);
        // Action
        List<Product> response = this.productService.findAll();
        // Assert
        assertEquals(products, response);
    }

    @Test
    public void givenProduct_whenFindByIdProduct_thenReturnProduct() {
        String _id = "12345";
        Optional<Product> optionalProduct = ProductServiceMock.mockOptionalProduct();
        Product expected = optionalProduct.get();
        when(this.productRepository.findById(any(String.class))).thenReturn(optionalProduct);
        // Action
        Product actual = this.productService.findById(_id);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void givenProduct_whenFindByNameProduct_thenReturnProduct() {
        String name = "Ahorro";
        Product mocked = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        Product expected = mocked;
        when(this.productRepository.findByName(any(String.class))).thenReturn(mocked);
        // Action
        Product actual = this.productService.findByName(name);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void givenListOfProducts_whenFindByStatusProducts_thenReturnListOfProducts() {
        String status = "ACTIVE";
        List<Product> mocked = ProductServiceMock.mockListOfProducts().stream().filter(product -> product.getStatus().equals(status)).toList();
        List<Product> expected = mocked.stream().filter(product -> product.getStatus().equals(status)).toList();
        when(this.productRepository.findByStatus(status)).thenReturn(mocked);
        // Action
        List<Product> actual = this.productService.findByStatus(status);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void givenProduct_whenSaveProduct_thenString() throws Exception {
        Product expect = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        Product product = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
        // Action
        this.productService.saveProduct(product);
        // Assert
        verify(this.productRepository).save(argument.capture());
        Product actual = argument.getValue();
        assertEquals(expect, actual);
    }

    @Test
    public void givenProduct_whenUpdateProduct_thenString() {
        String status = "INACTIVE";
        Product expected = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        expected.setStatus(status);

        Product product = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);

        when(this.productRepository.findByName(any(String.class))).thenReturn(product);
        // Action
        this.productService.updateProduct(status, product);
        // Assert
        verify(this.productRepository).save(argument.capture());
        assertEquals(expected.getStatus(), argument.getValue().getStatus());
    }

    @Test
    public void givenProduct_whenProductValidate_thenString() {
        List<Product> products = List.of(ProductServiceMock.mockListOfProducts().get(0));
        List<AssociatedServiceProduct> associatedServiceProducts = List
                .of(AssociatedServiceServiceProductMock.mockListOfAssociatedService().get(0));
        Product expected = products.get(0);
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);

        expected.getAssociatedService().add(associatedServiceProducts.get(0));
        when(this.productRepository.findById(any(String.class))).thenReturn(Optional.of(products.get(0)));
        verify(this.productRepository).save(argument.capture());
        // Action
        this.productService.linkAssociatedServices(products, associatedServiceProducts);
        // Assert
        assertEquals(expected, argument.getValue());
    }

    /*
     * @Test
     * public void givenProduct_whenLinkAssociatedServices_thenString() {
     * // given
     * List<Product> products = ProductServiceMock.mockListOfProducts();
     * List<AssociatedServiceProduct> associatedServiceProducts =
     * AssociatedServiceServiceProductMock
     * .mockListOfAssociatedService();
     * ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
     * // when
     * // then
     * this.productService.linkAssociatedServices(products,
     * associatedServiceProducts);
     * verify(this.productRepository, times(products.size())).save(argument.ca);
     * assertEquals(status, argument.getValue().getStatus());
     * }
     */

}
