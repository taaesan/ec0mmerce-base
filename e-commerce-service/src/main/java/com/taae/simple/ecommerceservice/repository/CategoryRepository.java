package com.taae.simple.ecommerceservice.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.taae.simple.ecommerceservice.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
	List<Category> findByParentIsNull();
}
