package com.sport.rental.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Lob
	@Column( length = 100000 )
	private String description;
	private int price;
	private String imageUrl;
	private Boolean isFree;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Storage storage;

	@OneToMany
	@JoinColumn(name = "item_id")
	private List<Reservation> reservationList;

	@OneToMany
	@JoinColumn(name = "item_id")
	private List<Comment> commentList;
}
