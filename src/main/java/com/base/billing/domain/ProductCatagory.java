package com.base.billing.domain;

public enum ProductCatagory {
	
	A("a"), B("b"), C("c");
	
	private String stringCode;
	
	ProductCatagory(String productCatagoryCode){
		this.stringCode = productCatagoryCode;
	}

	@Override
	public String toString(){
		return stringCode;
	}
	
	public static ProductCatagory getProductCatagory(String catagory){
		if(catagory != null){
			for(ProductCatagory productCatagory: ProductCatagory.values()){
				if(productCatagory.stringCode != null && productCatagory.stringCode.equalsIgnoreCase(catagory)){
					return productCatagory;
				}
			}
			
		}
		
		return null;
	}
}
