package com.base.billing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.billing.domain.BillDAO;
import com.base.billing.domain.BillRepository;
import com.base.billing.domain.ProductCatagory;
import com.base.billing.domain.ProductDAO;
import com.base.billing.representations.BillRequest;
import com.base.billing.representations.Product;

@Component
public class BillingService {
	
	@Autowired
	BillRepository billRepository;

	public BillDAO createBillForProducts(BillRequest billRequest) {
		
		BillDAO billDAO = new BillDAO();
		
		List<Product> products = billRequest.getProducts();
		
		int productsNumber = 0;
		
		double totalCost = 0;
		
		double totalTax = 0;
		
		double totalValue = 0;
		
		List<ProductDAO> productList = new ArrayList<ProductDAO>();
		
		for(Product product: products){
			
			ProductDAO productDAO = new ProductDAO();
			productDAO.setProductCategory(product.getProductCategory());
			productDAO.setProductName(product.getProductName());
			productDAO.setRate(product.getRate());
			
			productList.add(productDAO);
			
			productsNumber++;
			
			totalCost = totalCost + product.getRate();
			
			double taxForProduct = getTaxValueForProduct(ProductCatagory.getProductCatagory(product.getProductCategory()),  product.getRate());
			totalTax = totalTax + taxForProduct;
			
			totalValue = totalCost + totalTax;
			
		}
		
		billDAO.setProducts(productList);
		billDAO.setProductsNumber(productsNumber);
		billDAO.setTotalCost(totalCost);
		billDAO.setTotalTax(totalTax);
		billDAO.setTotalValue(totalValue);
		
		billRepository.save(billDAO);
		
		return billDAO;
	}

	private double getTaxValueForProduct(ProductCatagory productCategory, double rate) {
		
		double taxValue = 0;
		
		if (productCategory.equals(ProductCatagory.A)) {
			taxValue = rate * 1.1; // 10% levy

		} else if (productCategory.equals(ProductCatagory.B)) {
			taxValue = rate * 1.2; // 10% levy

		} else if (productCategory.equals(ProductCatagory.C)) {
			taxValue = 0;
		}
		
		return taxValue;
	}

	public BillDAO getBillById(Long id) {
		BillDAO billDAO = billRepository.findById(id);
		
		return billDAO;
	}

	public List<BillDAO> getBills() {
		
		List<BillDAO> bills = (List<BillDAO>) billRepository.findAll();
		return bills;
	}

	public void removeBills() {
			billRepository.deleteAll();
	}
	

}
