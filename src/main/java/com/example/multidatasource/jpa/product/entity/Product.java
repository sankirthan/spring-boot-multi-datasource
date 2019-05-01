package com.example.multidatasource.jpa.product.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="product_id")
	private Long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private BigDecimal price;
	
	public Product() {
	}

	public Product(Long id, String productName, BigDecimal price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
