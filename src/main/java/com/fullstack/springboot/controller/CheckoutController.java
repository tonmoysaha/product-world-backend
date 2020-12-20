package com.fullstack.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.springboot.dto.Purchase;
import com.fullstack.springboot.dto.PurchaseResponse;
import com.fullstack.springboot.service.CheckoutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private CheckoutService checkoutService;

	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/purchase")
	public PurchaseResponse palceOrder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseResponse = this.checkoutService.placeOrder(purchase);
		
		return purchaseResponse;
		
	}
	

}
