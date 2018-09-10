package com.taae.simple.ecommerceservice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taae.simple.ecommerceservice.model.Category;
import com.taae.simple.ecommerceservice.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ECommerceServiceApplicationTests {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	public void contextLoads() {
		System.out.println("context is loaded");
		
		List<Category> categories = categoryRepository.findAll();
		for(Category cat : categories){
			System.out.println(cat.getParentCatetoryName() + cat.getCategoryName());
			//recursiveTree(cat, "");
		}
		
		
	}
	
//	public void recursiveTree(Category cat, String prefix) {
//        System.out.println(prefix + cat.getCategoryName());
//        if (cat.getChildren().size() > 0) {
//            for (Category c : cat.getChildren()) {
//                recursiveTree(c, " - ");
//            }
//        }
//    }

}
