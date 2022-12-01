package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.CategoryDao;
import com.masai.Repository.ProductDao;
import com.masai.exception.AddProductException;
import com.masai.model.Category;
import com.masai.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	public ProductDao productdao;
	@Autowired
	public CategoryDao categorydao;

	@Override
	public Product AddProduct(Product product) throws AddProductException {
		
		Category category=product.getCatagory();
		category.getProduct().add(product);
        categorydao.save(category);
		return product;
	}

	@Override
	public String removeProductById(Integer id) throws AddProductException {
		
		Optional<Product> product=productdao.findById(id);
		if(product.isPresent()) {
			productdao.deleteById(id);
			return "product delete sucussfull";
		}
		
		throw new AddProductException("product not foud by given id");
		
		
	}

}
