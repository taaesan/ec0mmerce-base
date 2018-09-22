package com.taae.simple.ecommerceservice.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.taae.simple.ecommerceservice.model.Category;
import com.taae.simple.ecommerceservice.model.Parameter;
import com.taae.simple.ecommerceservice.model.Product;
import com.taae.simple.ecommerceservice.repository.CategoryRepository;
import com.taae.simple.ecommerceservice.repository.ProductRepository;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	//@Cacheable(value = "pages", key = "#pageAble.pageNumber")
	public Page<Product> list(Pageable pageAble) {
		Sort sort = Sort.by(new Order(Direction.DESC, "createdDate"), new Order(Direction.DESC, "id"));

		PageRequest page = PageRequest.of(pageAble.getPageNumber(), 10, sort);
		return productRepository.findAll(page);
	}

	@Override
	//@CacheEvict(value = "pages", key = "#body.page")
	public Page<Product> listByProduct(Parameter body) {
		Page<Product> result = null;

		Sort sort = Sort.by(new Order(Direction.DESC, "createdDate"), new Order(Direction.DESC, "id"));
		int pageIndex = 0;
		if (body.getPage() != null) {
			pageIndex = body.getPage();
		}
		PageRequest page = PageRequest.of(pageIndex, 10, sort);

		if (body.getPriceMax() != null && body.getPriceMax().intValue() < 50000) {
			result = productRepository.findByPrice(body.getPriceMax(), page);
		} else if (body.getProductName() != null && body.getCategoryId() == 0) {
			result = productRepository.findByProductName(body.getProductName(), page);
		} else if (body.getCategoryId() != 0) {
			result = productRepository.findByCategory(body.getCategoryId(), page);
		}

		return result;
	}

	@Override
	@Cacheable(value="allCategory", unless= "#result.size() == 0")
	public List<Category> listAllCategory() {
		
		List<Category> result = null;

		result = categoryRepository.findAll();

		return result;
	}

	@Override
	public Category searchCategoryById(Map<String, String> body) {
		Optional<Category> result = null;

		String id = body.get("id");

		if (id != null) {
			result = categoryRepository.findById(Long.valueOf(id));
		}

		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Product searchProductById(Map<String, String> body) {
		Optional<Product> result = null;

		String id = body.get("id");

		if (id != null) {
			result = productRepository.findById(Long.valueOf(id));
		}

		return result.isPresent() ? result.get() : null;
	}

	@Override
	// @CachePut(value="products", key="#body.productName")
	public Product saveProduct(Map<String, String> body) {
		Product result = null;

		String productId = body.get("productId");
		String newProductName = body.get("productName");
		long newCategoryId = Long.valueOf(body.get("categoryId"));
		String newPrice = body.get("price");

		// Update an existing product
		if (productId != null) {
			Optional<Product> existingProduct = productRepository.findById(Long.valueOf(productId));
			if (existingProduct.isPresent()) {
				Product product = existingProduct.get();
				product.setProductName(newProductName);
				product.setPrice(new BigDecimal(newPrice));

				if (newCategoryId != product.getCategoryId()) {
					Optional<Category> categoryOption = categoryRepository.findById(newCategoryId);
					product.setCategory(categoryOption.get());
					product.setCategoryId(categoryOption.get().getId());
				}

				// Save
				result = productRepository.save(product);
			}
		} else {
			// Add a new product
			Product product = new Product();
			product.setProductName(newProductName);
			product.setPrice(new BigDecimal(newPrice));
			product.setCreatedDate(new Date());

			Optional<Category> categoryOption = categoryRepository.findById(newCategoryId);
			product.setCategory(categoryOption.get());
			product.setCategoryId(categoryOption.get().getId());

			// Save
			result = productRepository.save(product);
		}

		return result;
	}

	@Override
	
	@Caching(evict = { 
			  @CacheEvict(value="allCategory", allEntries= true), 
			  @CacheEvict(value= "pages", allEntries= true) })
	public Category saveCategory(Map<String, String> body) {
		Category result = null;

		String categoryId = body.get("categoryId");
		String newCategoryName = body.get("categoryName");
		String newParentCategoryId = body.get("parentId");

		// Update an existing product
		if (categoryId != null) {
			Optional<Category> existingCategory = categoryRepository.findById(Long.valueOf(categoryId));
			if (existingCategory.isPresent()) {
				Category category = existingCategory.get();
				category.setCategoryName(newCategoryName);

				if (newParentCategoryId != null) {
					Optional<Category> categoryOption = categoryRepository.findById(Long.valueOf(newParentCategoryId));
					category.setParent(categoryOption.get());
				}

				// Save
				result = categoryRepository.save(category);
			}
		} else {
			// Add a new product
			Category category = new Category();
			category.setCategoryName(newCategoryName);

			Optional<Category> categoryOption = categoryRepository.findById(Long.valueOf(newParentCategoryId));
			category.setParent(categoryOption.get());

			// Save
			result = categoryRepository.save(category);
		}

		return result;
	}

	// @Override
	// @Caching(
	// put= { @CachePut(value= "categoryCache") },
	// evict= { @CacheEvict(value= "listCategoryCache", allEntries= true) }
	// )
	// public Category deleteCategory(Map<String, String> body) {
	// Category result = null;
	//
	// long categoryId = Long.valueOf(body.get("categoryId"));
	//
	// Optional<Category> rootCat = categoryRepository.findById(categoryId);
	// if (rootCat.isPresent()) {
	//
	// // Delete main
	// categoryRepository.deleteById(categoryId);
	// }
	//
	// return result;
	// }

	// @Override
	// @Caching(
	// put= { @CachePut(value= "categoryCache", key= "#result.categoryName") },
	// evict= { @CacheEvict(value= "listCategoryCache", allEntries= true) }
	// )
	// @Transactional
	// public Category deleteCategory(Map<String, String> body) {
	// Category result = null;
	//
	// long categoryId = Long.valueOf(body.get("categoryId"));
	//
	// Optional<Category> rootCat = categoryRepository.findById(categoryId);
	// if (rootCat.isPresent()) {
	//
	// entityManager.flush();
	// //entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY
	// FALSE").executeUpdate();
	// // Delete child first
	// System.out.println("Truncate Temp");
	// //productRepository.truncateTemp();
	// entityManager.createNativeQuery(" TRUNCATE TABLE
	// product_temp").executeUpdate();
	// entityManager.getTransaction().commit();
	//
	// System.out.println("Copy to Temp");
	// //productRepository.copyToTemp(categoryId);
	// Query query = entityManager.createNativeQuery("insert into
	// product_temp(id, category_id, created_date, price, product_name) select
	// id, category_id, created_date, price, product_name from product where
	// category_id != ?");
	// query.setParameter(1, categoryId);
	// query.executeUpdate();
	// entityManager.getTransaction().commit();
	//
	// System.out.println("Truncate Original");
	// //productRepository.truncateOriginal();
	// entityManager.createNativeQuery("TRUNCATE TABLE
	// product").executeUpdate();
	// entityManager.getTransaction().commit();
	//
	// System.out.println("Copy to Original");
	// //productRepository.copyToOriginal();
	// entityManager.createNativeQuery("insert into product(id, category_id,
	// created_date, price, product_name) select id, category_id, created_date,
	// price, product_name from product_temp ").executeUpdate();
	// entityManager.getTransaction().commit();
	//
	// entityManager.createNativeQuery("TRUNCATE TABLE
	// product_temp").executeUpdate();
	// entityManager.getTransaction().commit();
	// //entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY
	// TRUE").executeUpdate();
	//
	// // Delete main
	// categoryRepository.deleteById(categoryId);
	// }
	//
	// return result;
	// }

//	@Override
//	@CacheEvict(value="allCategory", allEntries= true)
//	public Category deleteCategory(Map<String, String> body) {
//		Category result = null;
//
//		long categoryId = Long.valueOf(body.get("categoryId"));
//
//		Optional<Category> rootCat = categoryRepository.findById(categoryId);
//		if (rootCat.isPresent()) {
//			// Delete child first
//
//			// Delete all child in product
//			List<Product> products = productRepository.findByCategory(categoryId);
//			for (Product product : products) {
//				productRepository.deleteById(product.getId());
//			}
//
//			List<Category> categories = categoryRepository.findCategoryChild(rootCat.get());
//			for (Category cat : categories) {
//
//				// Delete all child in product
//				products = productRepository.findByCategory(cat.getId());
//				for (Product product : products) {
//					productRepository.deleteById(product.getId());
//				}
//
//				// Delete main
//				categoryRepository.deleteById(cat.getId());
//			}
//
//			// Delete main
//			categoryRepository.deleteById(categoryId);
//		}
//
//		return result;
//	}
	
	@Override
	@CacheEvict(value="allCategory", allEntries= true)
	public Category deleteCategory(Map<String, String> body) {
		Category result = null;

		long categoryId = Long.valueOf(body.get("categoryId"));

		Optional<Category> rootCat = categoryRepository.findById(categoryId);
		if (rootCat.isPresent()) {

			// Delete main
			categoryRepository.deleteById(categoryId);
		}
		return result;
	}

	@Override
	public Product deleteProduct(Map<String, String> body) {
		Product result = null;

		long productId = Long.valueOf(body.get("productId"));

		productRepository.deleteById(productId);

		return result;
	}

}
