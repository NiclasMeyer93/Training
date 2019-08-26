package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Buch;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.BuchRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class DemoItfApplicationTests {

	@Autowired
	private BuchRepository repo;

	@Autowired
	private AutorRepository autorRepo;

	@Test
	public void testCount() {
		assertEquals(6, repo.count());
	}

	@Test
	public void testFindAutor() throws Exception {
		Autor autor = autorRepo.findByLastName("King");
		List<Buch> books = autor == null ? null : autor.getBooks();
		log.debug("Found {} books of author {}", books == null ? 0 : books.size(), "King");
	}

	@Test
	public void testAutor() {
		Buch buch1 = repo.findById(1).get();
		long i = autorRepo.count();
		Autor autor = new Autor();
		autor.setFirstName("Tobias");
		autor.setLastName("Orazem");
		autorRepo.save(autor);
		buch1.setAutor(autor);
		repo.save(buch1);
		long j = autorRepo.count();
		assertTrue("One new Author now present", j - i == 1);
	}

	@Test
	public void testFindByGenrename() throws Exception {
		String genre = "Horror";
		List<Buch> books = repo.findByGenreGenreName(genre);
		log.debug("Found {} books of genre {}", books == null ? 0 : books.size(), genre);
		assertEquals(2, books.size());
	}

	@Test
	public void testSave() {
		Buch buch = new Buch();
		buch.setPrice(11.11);
		buch.setTitle("Faker");
		buch.setPublished(LocalDate.now());
		buch.setAutor(autorRepo.findByLastName("King"));
		buch = repo.save(buch);
		assertEquals(4, autorRepo.findByLastName("King").getBooks().size());
	}

	@Test
	public void testReadAuthorAndGenre() {
		Optional<Buch> buchOptional = repo.findById(1);
		if (buchOptional.isPresent()) {
			log.debug(buchOptional.get().getAutor().getLastName());
			log.debug(buchOptional.get().getGenre().getGenreName());
		}

	}

	@Test
	public void testFindMostExpensiveBook() {
		log.debug("Most expensive price is {}", repo.findFirstByOrderByPriceDesc().getPrice());
	}

	@Test
	public void testFindByAutorLastName() {
		log.debug("Number of King's books {}", repo.findByAutorLastName("King").size());
	}

}
