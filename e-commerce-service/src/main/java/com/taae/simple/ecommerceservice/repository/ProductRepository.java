package com.taae.simple.ecommerceservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.taae.simple.ecommerceservice.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
