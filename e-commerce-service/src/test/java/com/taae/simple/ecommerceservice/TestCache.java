//package com.taae.simple.ecommerceservice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.taae.simple.ecommerceservice.model.Parameter;
//import com.taae.simple.ecommerceservice.service.AppService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestCache {
//
//	
//	@Autowired
//	private AppService appService;
//	
//	@Test
//	public void testCache(){
//		
//		Map<String,String> maps = new HashMap<>();
//		maps.put("page","1");
//		maps.put("categoryId", "1");
//		
//		Pageable page = PageRequest.of(1, 10, null);
//		appService.list(page);
////		appService.listByProduct(new Parameter(maps));
////		appService.list(page);
////		appService.list(page);
//		
//		
//	}
//	
//	@Test
//	public void testDeleteCat(){
//		Map<String,String> maps = new HashMap<>();
//		maps.put("page","1");
//		maps.put("categoryId", "11");
//		appService.deleteCategory(maps);
//	}
//	
//	
//}
