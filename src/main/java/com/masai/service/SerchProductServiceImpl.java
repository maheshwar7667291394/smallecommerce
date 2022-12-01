package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.CategoryDao;
import com.masai.Repository.ProductDao;
import com.masai.exception.SerchProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.model.SearchProduct;
@Service
public class SerchProductServiceImpl implements SerchProductService{
    @Autowired
	public ProductDao productdao;
    @Autowired
    public CategoryDao categorydao;
	
	@Override
	public List<Product> GetAllProduct(SearchProduct serchproduct) throws SerchProductException {
		
		List<Product> AllProductByname=productdao.findByproductName(serchproduct.getProductName());
		if(AllProductByname.size()!=0) {
			return AllProductByname;
		}
		
	  Category category=categorydao.findBycategoryname(serchproduct.getCatagoryName());
	  if(category!=null) {
		  List<Product> products=category.getProduct();
		  return products;
	  }
		throw new SerchProductException("No product found by this name nad by this category");
		
		
	}

	

}
