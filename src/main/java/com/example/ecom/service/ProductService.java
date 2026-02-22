package com.example.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.entity.Product;
import com.example.ecom.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
	private ProductRepository repo;

	/*
	 * private ProductRepository repo2;
	 * 
	 * public ProductService(ProductRepository repo2) { this.repo2=repo2; }
	 */
	
	public List<Product>getAllProducts(){
		return repo.findAll();
	}
	
	public String createProduct(Product p) {
		repo.save(p);
		
		return "product created";
		
	}
		
	public List<Product> getProductsByNameAndPrice(String name, float price) {

		return repo.findByNameAndPrice(name, price);

	}

	

	public List<Product> getProductsByNameJPQL(String name) {

		return repo.findByNameJPQL(name);

	}
		
	
}
