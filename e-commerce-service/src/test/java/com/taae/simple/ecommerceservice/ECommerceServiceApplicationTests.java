package com.taae.simple.ecommerceservice;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taae.simple.ecommerceservice.model.Category;
import com.taae.simple.ecommerceservice.model.Product;
import com.taae.simple.ecommerceservice.repository.CategoryRepository;
import com.taae.simple.ecommerceservice.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ECommerceServiceApplicationTests {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;

	@Test
	public void contextLoads() {
		System.out.println("context is loaded");

		Optional<Category> categories = categoryRepository.findById(13l);
		// for(Category cat : categories){
		// System.out.println(cat.getParentCatetoryName() +
		// cat.getCategoryName());
		// //recursiveTree(cat, "");
		// }

		if (categories.isPresent()) {

			int j = 1;
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, j++);
			
			for (int i = 0; i < 50; i++) {
				

				
				Product product = new Product();
				product.setProductName("Apple iPhone "+i);
				product.setCategory(categories.get());
				
				if(i % 10 == 0){
					cal.set(Calendar.DAY_OF_MONTH, j++);
				}
				
				product.setCreatedDate(cal.getTime());
				System.out.println(product.getCreatedDate());

				productRepository.save(product);
			}
		}

	}

	// public void recursiveTree(Category cat, String prefix) {
	// System.out.println(prefix + cat.getCategoryName());
	// if (cat.getChildren().size() > 0) {
	// for (Category c : cat.getChildren()) {
	// recursiveTree(c, " - ");
	// }
	// }
	// }

}
