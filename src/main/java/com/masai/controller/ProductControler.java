package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AddProductException;
import com.masai.exception.SerchProductException;
import com.masai.model.Product;
import com.masai.model.SearchProduct;
import com.masai.service.ProductService;
import com.masai.service.SerchProductService;
import com.masai.service.SerchProductServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductControler {
    @Autowired
	public SerchProductService serchProductByName;
    
    @Autowired
    public ProductService productservice;
    
	@GetMapping("/allproductbyname")
	public ResponseEntity<List<Product>> GetAllProDuctByNmae(@RequestBody SearchProduct serchproduct) throws SerchProductException{
		
		List<Product> allProductByNmae=serchProductByName.GetAllProduct(serchproduct);
		return new ResponseEntity<List<Product>>(allProductByNmae,HttpStatus.OK);
		
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> SaveProduct(@RequestBody Product product) throws AddProductException{
		
		
		Product savedProduct=productservice.AddProduct(product);
		return new ResponseEntity<Product>(savedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> DelateProductByid(@PathVariable Integer productId) throws AddProductException{
	 
		String result=productservice.removeProductById(productId);
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
}
