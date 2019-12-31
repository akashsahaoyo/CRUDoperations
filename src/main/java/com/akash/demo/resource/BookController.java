package com.akash.demo.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.demo.model.Book;
import com.akash.demo.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@PostMapping("/books")
	public String saveBook(@RequestBody Book book, HttpServletResponse httpRes, Throwable ex) {

		if (repository.existsById(book.getId())) {
			httpRes.setStatus(HttpStatus.BAD_REQUEST.value());
			// System.out.println("h");
			return "duplicate id";
		} else {
			// System.out.println("y");

			repository.save(book);
			return "Added book with id : " + book.getId();
		}

	}
	
	
	
	
	
	

	@GetMapping("/books")
	public List<Book> getBooks() {
		return repository.findAll(Sort.by("id"));
		
		//return repository.findAllpage(1,new PageRequest(0,3,Direction.ASC,"id")) ;
		//return List<Book> findByOrderByIdAsc;

		//return repository.findAll().sort();
	}

	@PutMapping("/books/{id}")
	public String update(@RequestBody Book book, @PathVariable int id, HttpServletResponse httpRes, Throwable ex) {
		if (repository.existsById(id)) {
			repository.save(book);
			return "updated";
		} else {
			httpRes.setStatus(HttpStatus.NOT_FOUND.value());
			return "invalid id";
		}
	}

	@GetMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable int id, HttpServletResponse httpRes, Throwable ex) {

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return "book deleted with id : " + id;
		} else {
			httpRes.setStatus(HttpStatus.NOT_FOUND.value());
			return "invalid id";
		}
	}

	@DeleteMapping("/booksAll")
	public String deleteallbook() {
		repository.deleteAll();
		return "all book deleted";
	}

}
