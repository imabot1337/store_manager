package store_manager.com.example.store_manager.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import store_manager.com.example.store_manager.controllers.ProductController;
import store_manager.com.example.store_manager.services.ProductService;

@Configuration
public class ProductControllerConfig {

    @Bean
    public ProductController productController(ProductService productService) {
        return new ProductController(productService);
    }
}
