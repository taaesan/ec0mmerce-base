package com.taae.simple.ecommerceservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taae.simple.ecommerceservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByParentIsNull();
}
