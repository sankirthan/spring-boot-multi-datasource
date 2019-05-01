package com.example.multidatasource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multidatasource.jpa.customer.entity.Customer;
import com.example.multidatasource.jpa.product.entity.Product;
import com.example.multidatasource.service.CustomerService;
import com.example.multidatasource.service.ProductService;

@RestController
public class Controller {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
}
