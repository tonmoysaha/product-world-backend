package com.fullstack.springboot.dto;

import java.util.Set;

import com.fullstack.springboot.entity.Address;
import com.fullstack.springboot.entity.Customer;
import com.fullstack.springboot.entity.Order;
import com.fullstack.springboot.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
