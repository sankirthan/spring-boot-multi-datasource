package com.example.multidatasource.jpa.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multidatasource.jpa.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
