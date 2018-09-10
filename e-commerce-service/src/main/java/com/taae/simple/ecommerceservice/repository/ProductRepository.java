package com.taae.simple.ecommerceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taae.simple.ecommerceservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
