package com.sport.rental.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sport.rental.model.Category;
import com.sport.rental.model.Item;

public interface ItemRepository extends CrudRepository<Item,Integer> {

	List<Item> findAll();

	Item findAllById(Integer id);

	List<Item> findAllByCategory(Category category);

	List<Item> findAllByName(String name);

	List<Item> findAllByIsFree(Boolean isFree);

	List<Item> findAllByIsFreeAndCategory(Boolean isFree, Category category);
}