package com.masai.service;

import java.util.List;

import com.masai.exception.SerchProductException;
import com.masai.model.Product;
import com.masai.model.SearchProduct;

public interface SerchProductService {
	
	public List<Product> GetAllProduct(SearchProduct serchproduct)throws SerchProductException;

}
