package com.taae.simple.ecommerceservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taae.simple.ecommerceservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("select s from Category s where s.parent = null")
	List<Category> findByParentIsNull();
	
	@Query("select s from Category s where s.parent = :category")
	List<Category> findCategoryChild(@Param("category") Category category);
	
}
