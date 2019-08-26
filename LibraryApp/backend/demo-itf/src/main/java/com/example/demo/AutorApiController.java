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
import com.example.demo.entity.Buch;
import com.example.demo.repository.AutorRepository;

import lombok.Data;

@Data
@RestController
@RequestMapping("api/author")
public class AutorApiController {

	@Autowired
	AutorRepository autorRepository;
	
	@GetMapping
	public Iterable<Autor> index() {
		return autorRepository.findAll();
}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getOneAutor(@PathVariable int id) {
		return ResponseEntity.of(autorRepository.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public void deleteBuch(@PathVariable int id) {
		autorRepository.deleteById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Autor> replaceBuch(@RequestBody Autor newAutor, @PathVariable int id) {
			if (autorRepository.findById(id).isPresent()) {
				newAutor.setId(id);
				return ResponseEntity.ok(autorRepository.save(newAutor));
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	@PostMapping
	public Autor create(@RequestBody Autor autor) {
		autor.setId(null);
		return autorRepository.save(autor);
	}
	
}


