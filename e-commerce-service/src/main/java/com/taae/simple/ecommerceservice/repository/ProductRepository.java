package com.taae.simple.ecommerceservice.repository;


import java.math.BigDecimal;
import java.util.List;

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
	
	@Query("select s from Product s where s.categoryId = :categoryId ")
	List<Product> findByCategory(@Param("categoryId") long categoryId);
	
	
//	//Technic to delete huge row
//	@Query(value="insert into product_temp(id, category_id, created_date, price, product_name) select id, category_id, created_date, price, product_name from product where category_id != :categoryId ", nativeQuery = true)
//	void copyToTemp(@Param("categoryId") long categoryId);
//	
//	@Query(value="insert into product(id, category_id, created_date, price, product_name) select id, category_id, created_date, price, product_name from product_temp  ", nativeQuery = true)
//	void copyToOriginal();
//	
//	@Query(value=" truncate table product ", nativeQuery = true)
//	void truncateOriginal();
//	
//	@Query(value=" truncate table product_temp ", nativeQuery = true)
//	void truncateTemp();
	
	
}