package com.desidukaan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.desidukaan.exception.ProductException;
import com.desidukaan.model.Product;
import com.desidukaan.repository.ProductDao;

public class ProductSeriveImpl implements ProductService {

	@Autowired
	private ProductDao pdao;
	
	@Override
	public List<Product> viewAllProduct() {
		List<Product> products = pdao.findAll();
		if(products.size() > 0) {
			return products;
		}
		else {
			throw new ProductException("Product not available");
		}
	}

	@Override
	public Product addProduct(Product product) {
		Product prod = pdao.save(product);
		return prod;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> opt = pdao.findById(product.getProductId());
		if(opt.isPresent()) {
			return pdao.save(product);
		}
		else {
			throw new ProductException("Invalid product details");
		}
	}

	@Override
	public Product viewProduct(Integer id) {
		Optional<Product> opt = pdao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new ProductException("Product is not available with id number "+id);
		}
	}

	@Override
	public List<Product> viewProductByCategory(String cName) {
		List<Product> products = pdao.viewByCategoryName(cName);
		if(products.size() > 0) {
			return products;
		}
		throw new ProductException("Product is not available with category name "+cName);
	}

	@Override
	public Product removeProduct(Integer pId) {
		Product prod = pdao.findById(pId).orElseThrow(()-> new ProductException("Product not availabe with product id "+pId));
		pdao.delete(prod);
		return prod;
	}

}
