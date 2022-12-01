package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	@PostMapping("/category")
	public  ResponseEntity<Category> SaveCategory(@RequestBody Category category) throws CategoryException{
		
		Category SavedCategory=categoryService.SaveCategory(category);
		return new ResponseEntity<Category>(SavedCategory,HttpStatus.OK);
		
	}

}
