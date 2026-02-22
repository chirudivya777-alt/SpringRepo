package com.example.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity  // this annotation will take care of table creation and column mapping
@Table
public class Product {
// ORM -> Object Relational Mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;//column in the table
	@Column(name="product_name", nullable =false)
	String name;
	
	@Column(name ="product_decsription")
	String description;
	
	@Min(1)
	@Column(name ="product_price", nullable = false)
	float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
