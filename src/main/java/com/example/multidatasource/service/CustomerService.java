package com.example.multidatasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.multidatasource.jpa.customer.entity.Customer;
import com.example.multidatasource.jpa.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
