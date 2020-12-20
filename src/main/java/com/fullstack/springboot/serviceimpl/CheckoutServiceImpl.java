package com.fullstack.springboot.serviceimpl;

import org.springframework.stereotype.Service;

import com.fullstack.springboot.dto.Purchase;
import com.fullstack.springboot.dto.PurchaseResponse;
import com.fullstack.springboot.repository.CustomerRepository;
import com.fullstack.springboot.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private CustomerRepository customerRepository;
	
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}



	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		return null;
	}

}
