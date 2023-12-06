package store_manager.com.example.store_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store_manager.com.example.store_manager.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
