package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.CategoryDao;
import com.masai.Repository.ProductDao;
import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.model.Product;

@Service
public class CategoryServiceImplements implements CategoryService{
	
	@Autowired
	public CategoryDao cdao;
	
	@Autowired
	public ProductDao productdao;

	@Override
	public Category SaveCategory(Category category) throws CategoryException{
		
		Category savedCategory=cdao.findBycategoryname(category.getCategoryname());
		
		if(savedCategory!=null) {
			throw new CategoryException("category already found ");
		}
		
		
		List<Product> products=category.getProduct();
		
		for(Product product:products) {
			product.setCatagory(category);
		}
		
		Category savedCat=cdao.save(category);
		return savedCat;
		
	}


	

}
