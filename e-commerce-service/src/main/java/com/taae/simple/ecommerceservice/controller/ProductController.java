package com.taae.simple.ecommerceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taae.simple.ecommerceservice.model.Product;
import com.taae.simple.ecommerceservice.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/productslist")
	Page<Product> list(@PageableDefault(sort = "id", size = 20)Pageable pageable){
		return productRepo.findAll(pageable);
	}

}
