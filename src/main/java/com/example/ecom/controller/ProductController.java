package com.example.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.entity.Product;
import com.example.ecom.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	@PostMapping("/products")
	public String createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}


	@GetMapping("/products")
	public List<Product> getProducts() {
		return service.getAllProducts();
	}
	
	@ExceptionHandler(Exception.class )
	public String handleExeception(Exception e) {
		return "An error occured "+e.getMessage();
	}
	
	@GetMapping("/product/search")
	public List<Product>searchProduct(@RequestParam String name,@RequestParam float price){
	return service.getProductsByNameAndPrice(name,price);
	
	}
	@GetMapping("/product/JPQL")
	public List<Product> searchProductJPQL(@RequestParam String name ){
	
	return service.getProductsByNameJPQL(name);
	}
	
	
	
	

	/*
	 * @PutMapping("/products/{id}") public String updateProduct(@PathVariable int
	 * id,@RequestBody String product) { if(id>=0 && id < products.size()) {
	 * products.set(id,product); return " product updtaed"; } else { return
	 * "product not found"; } }
	 * 
	 * @DeleteMapping("/products/query") public String deleteProduct(@RequestParam
	 * int id ) {
	 * 
	 * if(id>0&& id< products.size()) { products.remove(id);
	 * System.out.println("Delete mapping"); return " Product deleted"; }else {
	 * return" product not deleted"; } }
	 */


	
}