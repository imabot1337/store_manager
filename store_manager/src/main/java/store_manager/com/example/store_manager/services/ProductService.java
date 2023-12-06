package store_manager.com.example.store_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store_manager.com.example.store_manager.entities.Product;
import store_manager.com.example.store_manager.repositories.ProductRepository;
import store_manager.com.example.store_manager.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    private static Product updateProduct(Product savedProduct, Product product) {
        long currentTimeMillis = System.currentTimeMillis();
        return Product.builder()
                .id(savedProduct.getId())
                .name(product.getName())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .lastUpdated(currentTimeMillis)
                .build();

    }

}
