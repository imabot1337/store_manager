package store_manager.com.example.store_manager.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import store_manager.com.example.store_manager.entities.Product;
import store_manager.com.example.store_manager.repositories.ProductRepository;
import store_manager.com.example.store_manager.services.ProductService;
import store_manager.com.example.store_manager.exceptions.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private final static Product product = Product.builder()
            .id(1L)
            .name("TV")
            .description("altceva")
            .category("ceva")
            .price(2.0)
            .lastUpdated(0L)
            .build();

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @DisplayName("Test for get Product will return Product")
    @Test
    public void givenProductId_whenCreateProductById_thenReturnProductObject() {
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));

        Product savedProduct = productService.getProductById(product.getId());

        assertThat(savedProduct).isEqualTo(product);

        verify(productRepository, times(1)).findById(product.getId());
    }

    @DisplayName("Test for get Product will throw exception")
    @Test
    public void givenProductId_whenCreateProductById_thenThrowException() {
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            productService.getProductById(product.getId());
        });

        verify(productRepository, times(1)).findById(product.getId());
    }

    @DisplayName("Test for get all products")
    @Test
    public void givenNothing_whenGetAllProducts_thenListOfProducts() {
        Product anotherProduct = Product.builder()
                .id(2L)
                .name("SmartPhone")
                .description("best")
                .category("magic")
                .price(3.0)
                .lastUpdated(1L)
                .build();
        List<Product> products = List.of(product, anotherProduct);

        given(productRepository.findAll()).willReturn(products);

        List<Product> savedProducts = productService.getAll();

        Assertions.assertArrayEquals(savedProducts.toArray(), products.toArray());

        verify(productRepository, times(1)).findAll();
    }

    @DisplayName("Test for save Product")
    @Test
    public void givenProductObject_whenSaveProduct_thenReturnProductObject() {
        given(productRepository.save(product)).willReturn(product);

        Product savedProduct = productService.createProduct(product);

        assertThat(savedProduct).isNotNull();

        verify(productRepository, times(1)).save(product);
    }

    @DisplayName("Test for update Product")
    @Test
    public void givenProductObject_whenUpdateProduct_thenReturnUpdatedProductObject() {

        given(productRepository.save(product)).willReturn(product);

        Product savedProduct = productService.updateProduct(product);

        assertThat(savedProduct).isNotNull();

        verify(productRepository, times(1)).save(product);
    }

    @DisplayName("Test for delte Product")
    @Test
    public void givenProductObject_whenDeleteProduct_then() {
        willDoNothing().given(productRepository).delete(product);

        productService.deleteProduct(product);

        verify(productRepository, times(1)).delete(product);
    }
}
