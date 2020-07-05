package com.sport.rental.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sport.rental.model.Category;
import com.sport.rental.model.Storage;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

	List<Category> findAll();

	Category findAllById(Integer id);

	List<Category> findAllByName(String name);
	
}