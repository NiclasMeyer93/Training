package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api/genre")
public class GenreController {
	@Autowired
	GenreRepository genreRepository;

	@GetMapping
	public Iterable<Genre> index() {
		return genreRepository.findAll();

	}
	@GetMapping("/{id}")
	public ResponseEntity<Genre> getOneGenre(@PathVariable int id) {
		return ResponseEntity.of(genreRepository.findById(id));
	}
	@DeleteMapping("/{id}")
	public void deleteGenre(@PathVariable int id) {
		genreRepository.deleteById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Genre> replaceGenre(@RequestBody Genre newGenre, @PathVariable int id) {
			if (genreRepository.findById(id).isPresent()) {
				newGenre.setId(id);
				return ResponseEntity.ok(genreRepository.save(newGenre));
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	@PostMapping
	public Genre create(@RequestBody Genre genre) {
		genre.setId(null);
		return genreRepository.save(genre);
	}
}