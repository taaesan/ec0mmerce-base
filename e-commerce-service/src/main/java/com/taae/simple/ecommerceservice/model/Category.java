
package com.taae.simple.ecommerceservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findByParentIsNull", query = "select s from Category s where s.parent = null")
public class Category  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2463765515800739518L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "category_name")
	private String categoryName;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "parent_id")
	private Category parent;

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name="id")
	// private java.util.List<Category> children = new ArrayList<>();

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

	// public java.util.List<Category> getChildren() {
	// return children;
	// }
	//
	// public void setChildren(java.util.List<Category> children) {
	// this.children = children;
	// }

	// @ManyToMany(mappedBy="categories")
	// private java.util.Set<Product> products;

}
