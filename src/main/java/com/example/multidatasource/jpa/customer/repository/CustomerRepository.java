package com.example.multidatasource.jpa.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multidatasource.jpa.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
