package com.taae.simple.ecommerceservice.model;

import java.math.BigDecimal;
import java.util.Map;

public class Parameter {
	private Long productId;
	private String productName;
	
	private Long categoryId;
	
	private BigDecimal priceMax;
	
	private Integer page;
	
	public Parameter(Map<String, String> param){
		if(param.get("productId") != null){
			productId = Long.valueOf(param.get("productId"));
		}
		
		if(param.get("productName") != null){
			productName = param.get("productName");
		}
		
		if(param.get("categoryId") != null){
			categoryId = Long.valueOf(param.get("categoryId"));
		}
		
		if(param.get("page") != null){
			page = Integer.valueOf(param.get("page"));
		}
		
		if(param.get("priceMax") != null){
			priceMax = new BigDecimal(param.get("priceMax"));
		}
		
		
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(BigDecimal priceMax) {
		this.priceMax = priceMax;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}
