package com.desidukaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desidukaan.model.Product;
import com.desidukaan.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product) {
		
		Product addProd = prodServ.addProduct(product);
		return new ResponseEntity<Product>(addProd, HttpStatus.CREATED);
		
	}

}
