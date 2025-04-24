package com.celotts.product;

import com.celotts.product.domain.repository.ProductRepository;
import com.celotts.product.domain.service.ProductDomainService;

import com.celotts.product.infrastructure.persistence.ProductJpaRepository;
import com.celotts.product.infrastructure.persistence.ProductRepositoryAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	// Aquí hacemos magia: unir las piezas del rompecabezas hexagonal con beans
	@Bean
	public ProductRepository productRepository(ProductJpaRepository productoJpaRepositorio) {
		return new ProductRepositoryAdapter(productoJpaRepositorio);
	}

	@Bean
	public ProductDomainService productoServicioDominio(ProductRepository productRepository) {
		return new ProductDomainService(productRepository);
	}

	@Bean
	public ProductDomainService productDomainService(ProductRepository productRepository) {
		return new ProductDomainService(productRepository);
	}

}
