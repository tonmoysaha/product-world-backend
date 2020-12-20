package com.fullstack.springboot.service;

import com.fullstack.springboot.dto.Purchase;
import com.fullstack.springboot.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
