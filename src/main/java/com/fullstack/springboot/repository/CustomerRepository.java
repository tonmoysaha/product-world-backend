package com.fullstack.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
