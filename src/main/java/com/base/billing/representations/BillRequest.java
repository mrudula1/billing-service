package com.base.billing.representations;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillRequest {
	
	public static final String MEDIA_TYPE_BASE_VALUE = "application/vnd.base.bill.request";
	
	public static final String MEDIA_TYPE_JSON_VALUE = MEDIA_TYPE_BASE_VALUE + "+json";
	
	
	List<Product> products;


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
