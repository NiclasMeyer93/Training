package com.example.demo;

import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Buch;
import com.example.demo.repository.BuchRepository;

import lombok.Data;

@CrossOrigin(origins="http://localhost:4200")
@Data
@RestController
@RequestMapping("/book")
public class BuchApiController {

	@Autowired
	BuchRepository buchRepository;

	@GetMapping
	public Iterable<Buch> index() {
		return buchRepository.findAll();

	}
	
	@PostMapping
	public Buch create(@Valid @RequestBody Buch buch) {
		buch.setId(null);
		return buchRepository.save(buch);
	}
	
	@DeleteMapping("/{id}")
	public int deleteBuch(@PathVariable int id) {
		buchRepository.deleteById(id);
		return id;
	}
	
	// Get single item
	
	@GetMapping("/{id}")
	public ResponseEntity<Buch> getOneBuch(@PathVariable int id) {
		return ResponseEntity.of(buchRepository.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Buch> replaceBuch(@RequestBody Buch newBuch, @PathVariable int id) {
			if (buchRepository.findById(id).isPresent()) {
				newBuch.setId(id);
				return ResponseEntity.ok(buchRepository.save(newBuch));
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

