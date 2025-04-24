package com.celotts.product.domain.service;

import com.celotts.product.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductApplicationService {

    private final ProductDomainService productDomainService;

    public ProductApplicationService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    public Product createProduct(Product product) {
        return productDomainService.createProduct(product);
    }

    public List<Product> listProducts() {
        return productDomainService.listProducts();
    }

    public Optional<Product> getProduct(Long id) {
        return productDomainService.getProduct(id);
    }

    public void deleteProduct(Long id) {
        productDomainService.deleteProduct(id);
    }
}