
package com.taae.simple.ecommerceservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category  implements Serializable{

	public Category(){}
	
	public Category(String categoryName, Category parent) {
		super();
		this.categoryName = categoryName;
		this.parent = parent;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2463765515800739518L;

	@Id
	@GeneratedValue
	@OnDelete(action=OnDeleteAction.CASCADE)
	private long id;

	@Column(name = "category_name")
	private String categoryName;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "parent_id")
	private Category parent;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getParentCatetoryName() {
		StringBuilder result = new StringBuilder();
		Category cat = this.parent;
		while (cat != null) {
			result.insert(0, cat.getCategoryName()+", ");
			cat = cat.parent;
		}
		return result.toString();
	}


}
