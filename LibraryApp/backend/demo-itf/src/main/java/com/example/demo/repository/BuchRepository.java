package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Buch;

@Repository
public interface BuchRepository extends CrudRepository<Buch, Integer> {

	public Buch findFirstByOrderByPriceDesc();

	public List<Buch> findByAutorLastName(String lastname);

	public List<Buch> findByGenreGenreName(String name);

}
