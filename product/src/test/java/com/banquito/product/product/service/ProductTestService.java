package com.banquito.product.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.product.mock.ProductServiceMock;
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
        // given
        List<Product> products = ProductServiceMock.mockListOfProducts();
        // when
        when(this.productRepository.findAll()).thenReturn(products);
        // then
        List<Product> response = this.productService.findAll();

        verify(this.productRepository, times(1)).findAll();
        assertEquals(products, response);
    }

    @Test
    public void givenProduct_whenFindByIdProduct_thenReturnProduct() {
        // given
        String _id = "12345";
        Product product = ProductServiceMock.mockProduct(Optional.of("12345"), Optional.empty(), Optional.of("ACTIVE"));
        // when
        when(this.productRepository.findById(_id)).thenReturn(Optional.of(product));
        // then
        Product response = this.productService.findById(_id);

        verify(this.productRepository, times(1)).findById(_id);
        assertEquals(product, response);
    }

    @Test
    public void givenProduct_whenFindByNameProduct_thenReturnProduct() {
        // given
        String name = "Ahorro";
        Product product = ProductServiceMock.mockProduct(Optional.of("12345"), Optional.of("Ahorro"),
                Optional.of("ACTIVE"));
        // when
        when(this.productRepository.findByName(name)).thenReturn(product);
        // then
        Product response = this.productService.findByName(name);

        verify(this.productRepository, times(1)).findByName(name);
        assertEquals(product, response);
    }

    @Test
    public void givenListOfProducts_whenFindByStatusProducts_thenReturnListOfProducts() {
        // given
        String status = "ACTIVE";
        List<Product> products = ProductServiceMock.mockListOfProducts();
        List<Product> expected = products.stream().filter(product -> product.getStatus().equals(status)).toList();
        // when
        when(this.productRepository.findByStatus(status)).thenReturn(expected);
        // then
        List<Product> response = this.productService.findByStatus(status);

        verify(this.productRepository, times(1)).findByStatus(status);
        assertEquals(expected.size(), response.size());
    }

    @Test
    public void givenProduct_whenSaveProduct_thenString() {
        // given
        Product product = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
        // when
        this.productService.saveProduct(product);
        // then
        verify(this.productRepository, times(1)).save(argument.capture());
        assertEquals(product, argument.getValue());
    }

    @Test
    public void givenProduct_whenUpdateProduct_thenString() {
        // given
        String status = "INACTIVE";
        Product product = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
        // when
        when(this.productRepository.findByName(product.getName())).thenReturn(product);
        this.productService.updateProduct(status, product);
        // then
        verify(this.productRepository, times(1)).findByName(product.getName());
        verify(this.productRepository, times(1)).save(argument.capture());
        assertEquals(status, argument.getValue().getStatus());
    }

/*     @Test
    public void givenProduct_whenProductValidate_thenString() {
        // given
        Product product = ProductServiceMock.mockProduct(Optional.empty(), Optional.empty(), Optional.empty());
        // when
        when(this.productRepository.findById(_id)).thenReturn(Optional.of(product));
        // then
        this.productService.linkAssociatedServices(products, associatedServiceProducts);
        verify(this.productRepository, times(products.size())).save(argument.ca);
        assertEquals(status, argument.getValue().getStatus());
    }
 */
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
