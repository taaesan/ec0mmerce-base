package com.taae.simple.ecommerceservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.taae.simple.ecommerceservice.model.Category;
import com.taae.simple.ecommerceservice.model.Product;

public interface AppService {
	
	Page<Product> list(Pageable page);
	Page<Product> listByProduct(Map<String, String> param);
	List<Category> searchCategory(Map<String, String> param);
	Category searchCategoryById(Map<String, String> param);
	Product searchProductById(Map<String, String> param);
	Product saveProduct(Map<String, String> param);
	Category saveCategory(Map<String, String> param);
	Category deleteCategory(Map<String, String> param);
	Product deleteProduct(Map<String, String> param);

}
