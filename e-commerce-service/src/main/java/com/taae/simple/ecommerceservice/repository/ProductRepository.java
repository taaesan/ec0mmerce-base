package com.taae.simple.ecommerceservice.repository;


import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.taae.simple.ecommerceservice.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	
	@Query("select s from Product s where LOWER(s.productName) like CONCAT('%', LOWER(:productName), '%') ")
	Page<Product> findByProductName(@Param("productName") String productName, Pageable page);
	
	@Query("select s from Product s where s.categoryId = :categoryId ")
	Page<Product> findByCategory(@Param("categoryId") long categoryId, Pageable page);
	
	@Query("select s from Product s where s.price <= :priceMax ")
	Page<Product> findByPrice(@Param("priceMax") BigDecimal priceMax, Pageable page);
}
