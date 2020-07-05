package com.sport.rental.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sport.rental.model.Item;
import com.sport.rental.model.Reservation;
import com.sport.rental.model.User;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

	List<Reservation> findAll();

	List<Reservation> findAllByItemAndStartDate(Item item, LocalDate startDate);

	List<Reservation> findAllByUser(User user);

	List<Reservation> findAllByUserAndEndDate(User user, LocalDate endDat);

	Reservation findAllById(Integer id);
}