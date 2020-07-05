package com.sport.rental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sport.rental.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

	Optional<User> findByEmail(String email);

	List<User> findAll();

	List<User> findAllById(Integer id);
}