package com.base.billing.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.billing.domain.BillDAO;
import com.base.billing.domain.ProductDAO;
import com.base.billing.representations.Bill;
import com.base.billing.representations.Product;

@Component
public class BillingObjectConvertor {
	
	public Bill convertBillDAOToRepresentation(BillDAO billDAO){
		
		Bill bill = new Bill();
		
		bill.setId(billDAO.getId());
		List<Product> productsRep = new ArrayList<Product>();
		
		List<ProductDAO> products = billDAO.getProducts();
		for(ProductDAO productEntity : products){
			
			Product prod = new Product();
			prod.setProductCategory(productEntity.getProductCategory());
			prod.setProductName(productEntity.getProductName());
			prod.setRate(productEntity.getRate());
			
			productsRep.add(prod);
		}
		//bill.setProducts(billDAO.getProducts());
		bill.setProductsNumber(billDAO.getProductsNumber());
		bill.setTotalCost(billDAO.getTotalCost());
		bill.setTotalTax(billDAO.getTotalTax());
		bill.setTotalValue(billDAO.getTotalValue());
		
		return bill;
	}

}
