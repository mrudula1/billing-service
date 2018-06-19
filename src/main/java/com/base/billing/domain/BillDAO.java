package com.base.billing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "BILLS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BillDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ORACLE_DB_SEQ_ID")
	@Column(name = "BILL_ID", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "PRODUCT_NUMBER")
	private int productsNumber;
	
	@Column(name = "TOTAL_COST")
	private double totalCost;
	
	@Column(name = "TOTAL_TAX")
	private double totalTax;
	
	@Column(name = "TOTAL_VALUE")
	private double totalValue;
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = (CascadeType.ALL))
	private List<ProductDAO> products = new ArrayList<ProductDAO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<ProductDAO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDAO> products) {
		this.products = products;
	}
	
}
