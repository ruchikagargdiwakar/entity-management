package com.casestudy.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Product extends EntityItem{
	
	private String productCategory;
	private BigDecimal cost;
	
	protected Product() {}

	public Product(String name, String description, String productCategory, BigDecimal cost) {
		super(name, description);
		this.productCategory = productCategory;
		this.cost = cost;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product [productCategory=" + productCategory + ", cost=" + cost + "]";
	}	

}
