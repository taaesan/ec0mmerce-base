package com.taae.simple.ecommerceservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taae.simple.ecommerceservice.ProductFactory.Brand;
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
	public void testData(){
		Optional<Category> rootCat = categoryRepository.findById(5l);
		//Delete child first
		
		List<Category> categories = categoryRepository.findCategoryChild(rootCat.get());
		
		System.out.println(categories);
	}

	@Test
	public void genData() {
		System.out.println("context is loaded");
		
		//genMassProduct(1000, ProductFactory.getFactory(Brand.SUPER_DRY), 9l);
		//genMassProduct(1000, ProductFactory.getFactory(Brand.APPLE), 7l);
		//genMassProduct(1000, ProductFactory.getFactory(Brand.SAMSUNG), 8l);
	//genMassProduct(1000, ProductFactory.getFactory(Brand.QUILLA), 10l);
		genMassProduct(1000, ProductFactory.getFactory(Brand.DELL), 11l);
	}
	
	public void genMassProduct(int record, ProductFactory fac, long catId){
		Optional<Category> opt = categoryRepository.findById(catId);
		if(opt.isPresent()){
			Category cat = opt.get();
			
			Random rand = new Random();
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2017);
			
			for(int i = 0 ;i< record ;i++){
				
				Product product = fac.getRandom();
				
				Product temp = new Product();
				temp.setProductName(new String(product.getProductName()));
				temp.setPrice(product.getPrice());
				temp.setCategory(cat);
				temp.setCategoryId(cat.getId());
				
				cal.set(Calendar.MONTH, (rand.nextInt(100) % 11));
				cal.set(Calendar.DAY_OF_MONTH, (rand.nextInt(100) % 29)+1);
				
				temp.setCreatedDate(cal.getTime());
				
				productRepository.save(temp);
				System.out.println("gen :"+i);
			}
			
		}
	}
	
	


	
	
	
}

abstract class ProductFactory{
	public enum Brand {
		APPLE,
		SAMSUNG,
		SUPER_DRY,
		QUILLA,
		DELL
	}
	
	protected List<Product> products;
	
	abstract void createProduct();
	
	public Product getRandom(){
		Random rand = new Random();
		int index = rand.nextInt(10) % products.size();
		return products.get(index);
	}
	
	public static ProductFactory getFactory(Brand brand){
		ProductFactory fac = null;
		switch(brand){
		case APPLE : 
			fac = new AppleProduct();
			
			break;
		case SAMSUNG : 
			fac = new SamsungProduct();
			break;	
		case SUPER_DRY : 
			fac = new SuperDryProduct();
			break;	
		case QUILLA : 
			fac = new QuillaProduct();
			break;
		case DELL : 
			fac = new DellProduct();
			break;			
		default : return null;	
		}
		
		fac.createProduct();
		return fac;
	}
}

class AppleProduct extends ProductFactory{
	

	@Override
	void createProduct() {
		this.products = new ArrayList<>();
		this.products.add(new Product("iPhone Xs", BigDecimal.valueOf(49999)));
		this.products.add(new Product("iPhone Xr", BigDecimal.valueOf(25000)));
		this.products.add(new Product("Watch 4", BigDecimal.valueOf(15000)));
		this.products.add(new Product("iPhone X", BigDecimal.valueOf(25000)));
		this.products.add(new Product("iPhone 8", BigDecimal.valueOf(17000)));
		this.products.add(new Product("iPhone 7", BigDecimal.valueOf(15000)));
		this.products.add(new Product("iPhone SE", BigDecimal.valueOf(12000)));
		this.products.add(new Product("iPhone SE2", BigDecimal.valueOf(12000)));
		this.products.add(new Product("iPad Pro", BigDecimal.valueOf(22000)));
		this.products.add(new Product("Watch 4", BigDecimal.valueOf(15000)));
	}
}

class SamsungProduct extends ProductFactory{

	@Override
	void createProduct() {
		this.products = new ArrayList<>();
		this.products.add(new Product("Galaxy Note9", BigDecimal.valueOf(25000)));
		this.products.add(new Product("Galaxy S9", BigDecimal.valueOf(22000)));
		this.products.add(new Product("Galaxy Tab A", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy J7 16GB", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy J7 Prime", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy J3 16GB", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy On5 8GB", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy Luna 8GB", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy J3 Emerge", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Galaxy J7 Perx", BigDecimal.valueOf(12000)));
	}
}

class SuperDryProduct extends ProductFactory{

	@Override
	void createProduct() {
		this.products = new ArrayList<>();
		this.products.add(new Product("Orange Label Cotton Crew Jumper", BigDecimal.valueOf(1500)));
		this.products.add(new Product("Classic Pique Polo Shirt", BigDecimal.valueOf(3000)));
		this.products.add(new Product("Classic Pique Long Sleeve Polo Shirt", BigDecimal.valueOf(4500)));
		
		this.products.add(new Product("Fuji Double Zip Hooded Jacket", BigDecimal.valueOf(2200)));
		this.products.add(new Product("Air Corps Bomber Jacket", BigDecimal.valueOf(8000)));
		this.products.add(new Product("Arctic Pop Zip Hooded SD-Windcheater", BigDecimal.valueOf(7000)));
		this.products.add(new Product("Rotor Leather 4 Pocket Jacket", BigDecimal.valueOf(12000)));
		this.products.add(new Product("Vintage Logo Hoodie", BigDecimal.valueOf(3200)));
		
	}
}

class QuillaProduct extends ProductFactory{

	@Override
	void createProduct() {
		this.products = new ArrayList<>();
		this.products.add(new Product("เสื้อกันหนาว Quilla Autumn Windbreaker | Winter Jacket | Winter Coats | Winter Sweater", BigDecimal.valueOf(900)));
		this.products.add(new Product("QUILLA แจ็คเก็ตกันหนาว เสื้อโค้ท Elegant Short Double-breasted Overcoat", BigDecimal.valueOf(399)));
		this.products.add(new Product("QUILLA ชุดเดรสสไตล์เกาหลี Tri-Tone Long Pleated Dress", BigDecimal.valueOf(799)));
		this.products.add(new Product("QUILLA Bestselling Winter Jacket Korean Free Winter Leggings", BigDecimal.valueOf(599)));
		this.products.add(new Product("QUILLA เสื้อกันหนาว European NYC Printed Striped Sleeves ", BigDecimal.valueOf(350)));
		this.products.add(new Product("QUILLA เสื้อกันหนาว Classic Monochrome European Sweater", BigDecimal.valueOf(380)));
		this.products.add(new Product("QUILLA เสื้อกันหนาว Owl Print European Classic Sweater ", BigDecimal.valueOf(380)));
		
		this.products.add(new Product("QUILLA European Wrap-around | Asymmetrical | Classic Maxi Dresses 2017", BigDecimal.valueOf(900)));
		this.products.add(new Product("QUILLA แจ็คเก็ตกันหนาว เสื้อโค้ท Classic Slim Fit Single Button Coat", BigDecimal.valueOf(1200)));
		this.products.add(new Product("QUILLA แจ็คเก็ตฤดูหนาว Standing Hooded Collar Invisible Zipper Snap Button Down Coat with Chic Patch Designs", BigDecimal.valueOf(850)));
	}
}

class DellProduct extends ProductFactory{

	@Override
	void createProduct() {
		this.products = new ArrayList<>();
		this.products.add(new Product("7000 Gaming Series", BigDecimal.valueOf(47000)));
		this.products.add(new Product("Alienware 15", BigDecimal.valueOf(75000)));
		this.products.add(new Product("Alienware 17", BigDecimal.valueOf(80000)));
		this.products.add(new Product("XPS 13", BigDecimal.valueOf(65000)));
		this.products.add(new Product("XPS 15", BigDecimal.valueOf(68000)));
		this.products.add(new Product("G3 15\"", BigDecimal.valueOf(12000)));
		this.products.add(new Product("G7 17\"", BigDecimal.valueOf(15000)));
		this.products.add(new Product("3000 Series 14\" ", BigDecimal.valueOf(22000)));
		this.products.add(new Product("3000 Series 15\"", BigDecimal.valueOf(24000)));
		this.products.add(new Product("5000 Series 14\"", BigDecimal.valueOf(27000)));
	}
}

