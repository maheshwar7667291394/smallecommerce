package com.masai.service;

import com.masai.exception.AddProductException;
import com.masai.model.Product;

public interface ProductService {
	
	public Product AddProduct(Product product)throws AddProductException;
	public String removeProductById(Integer id) throws AddProductException;

}
