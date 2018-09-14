package com.taae.simple.ecommerceservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taae.simple.ecommerceservice.model.Category;
import com.taae.simple.ecommerceservice.model.Product;
import com.taae.simple.ecommerceservice.repository.CategoryRepository;
import com.taae.simple.ecommerceservice.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping("/productslist")
	Page<Product> list(Pageable pageable) {

		Sort sort = Sort.by(new Order(Direction.DESC, "createdDate"), new Order(Direction.DESC, "id"));

		PageRequest page = PageRequest.of(pageable.getPageNumber(), 10, sort);
		return productRepo.findAll(page);
	}

	@CrossOrigin
	@PostMapping("/searchproduct")
	Page<Product> listByProduct(@RequestBody Map<String,String> body) {

		Page<Product> result = null;

		Sort sort = Sort.by(new Order(Direction.DESC, "createdDate"), new Order(Direction.DESC, "id"));
		int pageIndex = 0;
		if(body.get("page") != null){
			pageIndex = Integer.parseInt(body.get("page"));
		}
		PageRequest page = PageRequest.of(pageIndex, 10, sort);

		if (body.get("productName") != null && body.get("categoryId") == null) {
			result = productRepo.findByProductName(body.get("productName"), page);
		}

		return result;
	}
	
	@CrossOrigin
	@PostMapping("/searchcategory")
	List<Category> searchCategory(@RequestBody Map<String,String> body) {

		List<Category> result = null;
		
		String categoryName = body.get("categoryName");

		if (categoryName == null) {
			result = categoryRepo.findAll();
		}

		return result;
	}

}
