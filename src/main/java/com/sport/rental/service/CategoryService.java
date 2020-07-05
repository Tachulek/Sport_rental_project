package com.sport.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.rental.model.Category;
import com.sport.rental.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		List<Category> categoryList = categoryRepository.findAll();
		return categoryList;
	}

	public Category getCategory(Integer id){
		return categoryRepository.findAllById(id);
	}
}