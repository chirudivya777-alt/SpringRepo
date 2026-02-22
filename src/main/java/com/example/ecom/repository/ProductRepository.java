package com.example.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product>findByName(String name);
	List<Product>findByPriceGreaterThan(float price);
	List<Product>findByNameAndPrice(String name , float price);

	
	
	@Query("SELECT p FROM Product p WHERE p.name = :name" )
	List<Product>findByNameJPQL( @Param("name") String name );
	
	
	@NativeQuery(value =" SELECT * FROM Product  WHERE name =:name")
	List<Product>findByNameNative(@Param("name") String name );
}
