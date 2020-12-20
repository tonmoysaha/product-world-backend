package com.fullstack.springboot.serviceimpl;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fullstack.springboot.dto.Purchase;
import com.fullstack.springboot.dto.PurchaseResponse;
import com.fullstack.springboot.entity.Customer;
import com.fullstack.springboot.entity.Order;
import com.fullstack.springboot.entity.OrderItem;
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
		
		Order order = purchase.getOrder();
		
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(order.getShippingAddress());
		
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		this.customerRepository.save(customer);
		
		return new PurchaseResponse(orderTrackingNumber);
	}


	private String generateOrderTrackingNumber() {
		
		return UUID.randomUUID().toString();
	}

}
