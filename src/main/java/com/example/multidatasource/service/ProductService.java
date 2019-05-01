package com.example.multidatasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.multidatasource.jpa.product.entity.Product;
import com.example.multidatasource.jpa.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly=true, transactionManager="productTransactionManager")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
