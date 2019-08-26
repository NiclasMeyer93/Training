package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Buch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@DecimalMin("0")
	@Column(name = "price")
	private double price;
	@DateTimeFormat
	@Column(name = "published")
	private LocalDate published;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

}
