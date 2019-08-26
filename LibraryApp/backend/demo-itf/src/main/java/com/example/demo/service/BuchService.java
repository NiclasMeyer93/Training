package com.example.demo.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Buch;
import com.example.demo.repository.BuchRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BuchService {

	@Autowired
	private BuchRepository buchRepository;

	// @EnableScheduling in der Main Klasse hinzufügen
//	@Scheduled(fixedDelay = 1000)
	public void execute() {
		Buch buch = new Buch();
		buch.setPrice(11.11);
		buch.setTitle("Lombok?");
		buch.setPublished(LocalDate.now());
		buch = buchRepository.save(buch);
		log.info("Saved book with id {}", buch.getId());

	}

//	Buch buch2 = buchRepository.findById(1).get();
//	System.out.println(buch2.getAutor());
}
