package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.BuchRepository;

@RequestMapping("/books")
@Controller
public class BuchHtmlController {

	@Autowired
	private BuchRepository buchRepository;

	@GetMapping
	public String index(Model model) {

		model.addAttribute("bookList", buchRepository.findAll());
		model.addAttribute("count", buchRepository.count());
		return "books";
	}

}
