package com.desidukaan.service;

import java.util.List;

import com.desidukaan.model.Product;

public interface ProductService {
	
	public List<Product> viewAllProduct();
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Product viewProduct(Integer id);
	
	public List<Product> viewProductByCategory(String cName);
	
	public Product removeProduct(Integer pId);

}
