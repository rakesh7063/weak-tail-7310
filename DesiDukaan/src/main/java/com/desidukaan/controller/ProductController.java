package com.desidukaan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desidukaan.exception.ProductException;
import com.desidukaan.model.Product;
import com.desidukaan.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProductsHandler() {
		List<Product> products = prodServ.viewAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product) throws ProductException {
		
		Product addProd = prodServ.addProduct(product);
		return new ResponseEntity<Product>(addProd, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) {
		Product prod = prodServ.updateProduct(product);
		return new ResponseEntity<Product>(prod, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/{prodId}")
	public ResponseEntity<Product> viewProductHandler(@PathVariable("prodId") Integer prodId) {
		Product product = prodServ.viewProduct(prodId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/products/category/{categoryName}")
	public ResponseEntity<List<Product>> viewProductByCategoryHandler(@PathVariable("categoryName") String categoryName) {
		List<Product> prodCateg = prodServ.viewProductByCategory(categoryName);
		return new ResponseEntity<List<Product>>(prodCateg, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("productId") Integer productId) {
		Product product = prodServ.removeProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
