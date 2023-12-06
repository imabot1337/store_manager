package store_manager.com.example.store_manager.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import store_manager.com.example.store_manager.repositories.ProductRepository;
import store_manager.com.example.store_manager.services.ProductService;

@Configuration
public class ProductServiceConfig {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
