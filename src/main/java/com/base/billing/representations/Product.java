package com.base.billing.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	@JsonProperty
	private String productName;
	
	@JsonProperty
	private String productCategory;
	
	@JsonProperty
	private double rate;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	

}
