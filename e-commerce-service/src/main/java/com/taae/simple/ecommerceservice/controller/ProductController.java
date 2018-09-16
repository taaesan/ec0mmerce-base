//package com.taae.simple.ecommerceservice.controller;
//
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort.Order;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.taae.simple.ecommerceservice.model.Category;
//import com.taae.simple.ecommerceservice.model.Product;
//import com.taae.simple.ecommerceservice.repository.CategoryRepository;
//import com.taae.simple.ecommerceservice.repository.ProductRepository;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class ProductController {
//
//	@Autowired
//	ProductRepository productRepo;
//
//	@Autowired
//	CategoryRepository categoryRepo;
//
//	@GetMapping("/productslist")
//	Page<Product> list(Pageable pageable) {
//
//		Sort sort = Sort.by(new Order(Direction.DESC, "createdDate"), new Order(Direction.DESC, "id"));
//
//		PageRequest page = PageRequest.of(pageable.getPageNumber(), 10, sort);
//		return productRepo.findAll(page);
//	}
//
//	@CrossOrigin
//	@PostMapping("/searchproduct")
//	Page<Product> listByProduct(@RequestBody Map<String, String> body) {
//
//		Page<Product> result = null;
//
//		Sort sort = Sort.by(new Order(Direction.DESC, "createdDate"), new Order(Direction.DESC, "id"));
//		int pageIndex = 0;
//		if (body.get("page") != null) {
//			pageIndex = Integer.parseInt(body.get("page"));
//		}
//		PageRequest page = PageRequest.of(pageIndex, 10, sort);
//
//		String productName = body.get("productName");
//		long categoryId = Long.parseLong(body.get("categoryId"));
//		BigDecimal priceMax = new BigDecimal(body.get("priceMax"));
//
//		if (priceMax.intValue() < 50000) {
//			result = productRepo.findByPrice(priceMax, page);
//		} else if (productName != null && categoryId == 0) {
//			result = productRepo.findByProductName(productName, page);
//		} else if (categoryId != 0) {
//			result = productRepo.findByCategory(categoryId, page);
//		}
//
//		return result;
//	}
//
//	@CrossOrigin
//	@PostMapping("/searchcategory")
//	List<Category> searchCategory(@RequestBody Map<String, String> body) {
//
//		List<Category> result = null;
//
//		String categoryName = body.get("categoryName");
//
//		if (categoryName == null) {
//			result = categoryRepo.findAll();
//		}
//
//		return result;
//	}
//
//	@CrossOrigin
//	@PostMapping("/searchcategoryid")
//	Category searchCategoryById(@RequestBody Map<String, String> body) {
//
//		Optional<Category> result = null;
//
//		String id = body.get("id");
//
//		if (id != null) {
//			result = categoryRepo.findById(Long.valueOf(id));
//		}
//
//		return result.isPresent() ? result.get() : null;
//	}
//
//	@CrossOrigin
//	@PostMapping("/searchproduct.id")
//	Product searchProductById(@RequestBody Map<String, String> body) {
//
//		Optional<Product> result = null;
//
//		String id = body.get("id");
//
//		if (id != null) {
//			result = productRepo.findById(Long.valueOf(id));
//		}
//
//		return result.isPresent() ? result.get() : null;
//	}
//
//	@CrossOrigin
//	@PostMapping("/saveproduct")
//	Product saveProduct(@RequestBody Map<String, String> body) {
//
//		Product result = null;
//
//		String productId = body.get("productId");
//		String newProductName = body.get("productName");
//		long newCategoryId = Long.valueOf(body.get("categoryId"));
//		String newPrice = body.get("price");
//
//		// Update an existing product
//		if (productId != null) {
//			Optional<Product> existingProduct = productRepo.findById(Long.valueOf(productId));
//			if (existingProduct.isPresent()) {
//				Product product = existingProduct.get();
//				product.setProductName(newProductName);
//				product.setPrice(new BigDecimal(newPrice));
//
//				if (newCategoryId != product.getCategoryId()) {
//					Optional<Category> categoryOption = categoryRepo.findById(newCategoryId);
//					product.setCategory(categoryOption.get());
//					product.setCategoryId(categoryOption.get().getId());
//				}
//
//				// Save
//				result = productRepo.save(product);
//			}
//		} else {
//			// Add a new product
//			Product product = new Product();
//			product.setProductName(newProductName);
//			product.setPrice(new BigDecimal(newPrice));
//			product.setCreatedDate(new Date());
//
//			Optional<Category> categoryOption = categoryRepo.findById(newCategoryId);
//			product.setCategory(categoryOption.get());
//			product.setCategoryId(categoryOption.get().getId());
//
//			// Save
//			result = productRepo.save(product);
//		}
//
//		return result;
//	}
//
//	@CrossOrigin
//	@PostMapping("/savecategory")
//	Category saveCategory(@RequestBody Map<String, String> body) {
//
//		Category result = null;
//
//		String categoryId = body.get("categoryId");
//		String newCategoryName = body.get("categoryName");
//		String newParentCategoryId = body.get("parentId");
//
//		// Update an existing product
//		if (categoryId != null) {
//			Optional<Category> existingCategory = categoryRepo.findById(Long.valueOf(categoryId));
//			if (existingCategory.isPresent()) {
//				Category category = existingCategory.get();
//				category.setCategoryName(newCategoryName);
//
//				if (newParentCategoryId != null) {
//					Optional<Category> categoryOption = categoryRepo.findById(Long.valueOf(newParentCategoryId));
//					category.setParent(categoryOption.get());
//				}
//
//				// Save
//				result = categoryRepo.save(category);
//			}
//		} else {
//			// Add a new product
//			Category category = new Category();
//			category.setCategoryName(newCategoryName);
//
//			Optional<Category> categoryOption = categoryRepo.findById(Long.valueOf(newParentCategoryId));
//			category.setParent(categoryOption.get());
//
//			// Save
//			result = categoryRepo.save(category);
//		}
//
//		return result;
//	}
//
//	@CrossOrigin
//	@PostMapping("/delete.category")
//	Category deleteCategory(@RequestBody Map<String, String> body) {
//		Category result = null;
//
//		long categoryId = Long.valueOf(body.get("categoryId"));
//
//		Optional<Category> rootCat = categoryRepo.findById(categoryId);
//		if (rootCat.isPresent()) {
//			// Delete child first
//
//			// Delete all child in product
//			List<Product> products = productRepo.findByCategory(categoryId);
//			for (Product product : products) {
//				productRepo.deleteById(product.getId());
//			}
//
//			List<Category> categories = categoryRepo.findCategoryChild(rootCat.get());
//			for (Category cat : categories) {
//
//				// Delete all child in product
//				products = productRepo.findByCategory(cat.getId());
//				for (Product product : products) {
//					productRepo.deleteById(product.getId());
//				}
//
//				// Delete main
//				categoryRepo.deleteById(cat.getId());
//			}
//
//			// Delete main
//			categoryRepo.deleteById(categoryId);
//		}
//
//		return result;
//	}
//
//	@CrossOrigin
//	@PostMapping("/delete.product")
//	Product deleteProduct(@RequestBody Map<String, String> body) {
//		Product result = null;
//
//		long productId = Long.valueOf(body.get("productId"));
//
//		productRepo.deleteById(productId);
//
//		return result;
//	}
//
//}
