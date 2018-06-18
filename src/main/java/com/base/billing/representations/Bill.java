package com.base.billing.representations;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Bill implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String MEDIA_TYPE_BASE_VALUE = "application/vnd.base.bill";
	
	public static final String MEDIA_TYPE_JSON_VALUE = MEDIA_TYPE_BASE_VALUE + "+json";
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private int productsNumber;
	
	@JsonProperty
	private double totalCost;

	@JsonProperty
	private double totalTax;

	@JsonProperty
	private double totalValue;
	
	@JsonProperty
	private List<Product> products;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getProductsNumber() {
		return productsNumber;
	}

	public void setProductsNumber(int productsNumber) {
		this.productsNumber = productsNumber;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	
}
