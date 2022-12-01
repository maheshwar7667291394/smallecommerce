package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.exception.CategoryException;
import com.masai.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	public Category findBycategoryname(String categoryName);
	
}