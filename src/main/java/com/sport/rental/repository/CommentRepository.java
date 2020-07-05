package com.sport.rental.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sport.rental.model.Comment;
import com.sport.rental.model.Item;
import com.sport.rental.model.User;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {

	List<Comment> findAll();

	List<Comment> findAllByUser(User user);

	List<Comment> findAllByItem(Item item);

	List<Comment> findAllByUserAndItem(User user, Item item);
}
