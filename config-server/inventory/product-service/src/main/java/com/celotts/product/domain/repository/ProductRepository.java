package com.celotts.product.domain.repository;
import com.celotts.product.domain.model.Product;

import java.util.Optional;
import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}