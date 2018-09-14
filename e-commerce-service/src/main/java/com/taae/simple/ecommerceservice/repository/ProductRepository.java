package com.taae.simple.ecommerceservice.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.taae.simple.ecommerceservice.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	
	Page<Product> findByProductName(@Param("productName") String productName, Pageable page);
}
