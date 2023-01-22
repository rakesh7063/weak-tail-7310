package com.desidukaan.service;

import java.util.List;

import com.desidukaan.exception.ProductException;
import com.desidukaan.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public List<Product> viewAllProduct() throws ProductException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product viewProduct(Integer id) throws ProductException;
	
	public List<Product> viewProductByCategory(String cName) throws ProductException;
	
	public Product removeProduct(Integer pId) throws ProductException;

}
