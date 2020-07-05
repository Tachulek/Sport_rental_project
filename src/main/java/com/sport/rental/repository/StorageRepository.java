package com.sport.rental.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sport.rental.model.Storage;

@Repository
public interface StorageRepository extends CrudRepository<Storage,Integer> {

	List<Storage> findAll();

	List<Storage> findAllByName(String name);

	Storage findAllById(Integer id);

}