package com.base.billing;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.billing.domain.BillDAO;
import com.base.billing.exception.BadRequestException;
import com.base.billing.representations.*;
import com.base.billing.util.BillingObjectConvertor;

@RestController
public class BillingController {
	
	@Autowired
	BillingService billingService;
	
	@Autowired
	BillingObjectConvertor billingObjectConvertor;
	
	
	
	@RequestMapping(value = "/bill", method = RequestMethod.POST)
	public ResponseEntity<Bill> createBill(@Valid @RequestBody BillRequest billRequest, BindingResult bindingResult){
		
		if(bindingResult != null){
			
			validateResource(billRequest, bindingResult);
		}
		
		BillDAO billDAO = billingService.createBillForProducts(billRequest);
		
		Bill bill = billingObjectConvertor.convertBillDAOToRepresentation(billDAO);
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<Bill>(bill, headers, HttpStatus.CREATED);
		
	}

	private void validateResource(BillRequest billRequest,BindingResult bindingResult) throws BadRequestException{
		
		BadRequestException badRequest = null;
		
		if(bindingResult.hasErrors()){
			
			if(bindingResult.getFieldErrors().size() > 0 || bindingResult.getGlobalErrors().size() >0) {
				badRequest = new BadRequestException("Invalid billing request");
				
				throw badRequest;
			}
		}
		
	}
	
       
    @RequestMapping("/getBillByid")
    public ResponseEntity<Bill> findById(@RequestParam("id") String id){

    	BillDAO billDAO = billingService.getBillById(id);
		
		Bill bill = billingObjectConvertor.convertBillDAOToRepresentation(billDAO);
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<Bill>(bill, headers, HttpStatus.CREATED);
    }

}
