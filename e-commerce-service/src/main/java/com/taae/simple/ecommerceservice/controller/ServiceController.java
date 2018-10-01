package com.taae.simple.ecommerceservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taae.simple.ecommerceservice.model.Category;
import com.taae.simple.ecommerceservice.model.Parameter;
import com.taae.simple.ecommerceservice.model.Product;
import com.taae.simple.ecommerceservice.service.AppService;

@RestController
@CrossOrigin(origins = "*")
public class ServiceController {
	
	@Autowired
	private AppService service;

	@GetMapping("/productslist")
	Page<Product> list(Pageable page) {
		return service.list(page);
	}

	@CrossOrigin
	@PostMapping("/searchproduct")
	Page<Product> listByProduct(@RequestBody Map<String, String> body) {
		return service.listByProduct(new Parameter(body));
	}

	@CrossOrigin
	@PostMapping("/searchcategory")
	List<Category> searchCategory(@RequestBody Map<String, String> body) {
		return service.listAllCategory();
	}

	@CrossOrigin
	@PostMapping("/searchcategoryid")
	Category searchCategoryById(@RequestBody Map<String, String> body) {
		return service.searchCategoryById(body);
	}

	@CrossOrigin
	@PostMapping("/searchproduct.id")
	Product searchProductById(@RequestBody Map<String, String> body) {
		return service.searchProductById(body);
	}

	@CrossOrigin
	@PostMapping("/saveproduct")
	Product saveProduct(@RequestBody Map<String, String> body) {
		return service.saveProduct(body);
	}

	@CrossOrigin
	@PostMapping("/savecategory")
	Category saveCategory(@RequestBody Map<String, String> body) {
		return service.saveCategory(body);
	}

	@CrossOrigin
	@PostMapping("/delete.category")
	Category deleteCategory(@RequestBody Map<String, String> body) {
		return service.deleteCategory(body);
	}

	@CrossOrigin
	@PostMapping("/delete.product")
	Product deleteProduct(@RequestBody Map<String, String> body) {
		return service.deleteProduct(body);
	}

}
