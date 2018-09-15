package com.taae.simple.ecommerceservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
	public void genData() {
		System.out.println("context is loaded");
		
		
		//Category
//		List<Category> categories = new ArrayList<>();
//		
//		categories.add(new Category("Fashion", null));
//		categories.add(new Category("Electronics", null));
//		
//		categories.add(new Category("Clothing for Women", categories.get(0)));
//		categories.add(new Category("Clothing for Men", categories.get(0)));
//		categories.add(new Category("Mobiles & Tablets", categories.get(1)));
//		categories.add(new Category("Computers & Laptops", categories.get(1)));
//
//		
//		categoryRepository.saveAll(categories);
		//categoryRepository.save(new Category("Apple", null));
		

		Optional<Category> appleCat = categoryRepository.findById(3l);


		if (appleCat.isPresent()) {

			int j = 1;
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, 7);
			cal.set(Calendar.DATE, j++);
			
			Random rand = new Random();
			
			
			for (int i = 0; i < 20; i++) {
				
				int index = rand.nextInt(10) % 5;
				
				Product product = new Product();
				product.setProductName(womenFashion[index]);
				product.setPrice(BigDecimal.valueOf(womenFashionPrice[index]));
				product.setCategoryId(appleCat.get().getId());
				
				if(i % 10 == 0){
					int dayOfMonth = (j % 29) + 1;
					cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
					j++;
				}
				
				product.setCreatedDate(cal.getTime());
				System.out.println(product.getCreatedDate());

				productRepository.save(product);
			}
		}

	}
	
	static String [] womenFashion = new String[]{
			"QUILLA European Wrap-around | Asymmetrical | Classic Maxi Dresses 2017",
			"[Polo Ralph Lauren] Big Pony Long Sleeve Oxford: 100% Authentic USA",
			"QUILLA แจ็คเก็ตกันหนาว เสื้อโค้ท Classic Slim Fit Single Button Coat",
			"Positive ชุดนอนบางเบา ชุดนอนเซ็กซี่ ชุดนอนลายลูกไม้ ชุดนอนไม่ได้นอน ชุดนอนสำหรับสุภาพสตรี Sexy nightwear (Red/สีแดง)",
			"QUILLA แจ็คเก็ตฤดูหนาว Standing Hooded Collar Invisible Zipper Snap Button Down Coat with Chic Patch Designs"
			};
	static int [] womenFashionPrice = new int[]{500, 1000, 1500, 99,2000};
	
	static String [] appleFam = new String[]{"iPhone Xs","iPhone Xr","Watch 4"};
	static int [] appleFamPrice = new int[]{49000,26000,15000};
	

	// public void recursiveTree(Category cat, String prefix) {
	// System.out.println(prefix + cat.getCategoryName());
	// if (cat.getChildren().size() > 0) {
	// for (Category c : cat.getChildren()) {
	// recursiveTree(c, " - ");
	// }
	// }
	// }

}
