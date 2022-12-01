package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer categoryId;
	private String categoryname;
	
	
	@JsonIgnore
	@OneToMany(cascade =javax.persistence.CascadeType.ALL,mappedBy = "catagory")
	List<Product> product=new ArrayList<>();
	

}
