package com.celotts.product.infrastructure.controller;


import com.celotts.product.domain.model.Product;
import com.celotts.product.domain.service.ProductApplicationService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productApplicationService.createProduct(product);
    }

    @GetMapping
    public List<Product> listProducts() {
        return productApplicationService.listProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productApplicationService.getProduct(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productApplicationService.deleteProduct(id);
    }
}