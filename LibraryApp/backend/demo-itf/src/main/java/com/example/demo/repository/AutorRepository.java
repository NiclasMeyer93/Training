package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

	public Autor findByLastName(String lastname);
}
