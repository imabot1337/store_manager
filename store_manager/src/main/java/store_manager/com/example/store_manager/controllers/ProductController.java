package store_manager.com.example.store_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import store_manager.com.example.store_manager.entities.Product;
import store_manager.com.example.store_manager.services.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product", description = "Product API")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/find-product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/find-all-products")
    public List<Product> getProductById() {
        return productService.getAll();
    }

    @PostMapping("/create-product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete-product")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
    }

}
