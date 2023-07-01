package com.humber.eap.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humber.eap.model.Book;
import com.humber.eap.services.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	//get book by id API end point: http://localhost:8080/api/book/1
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Book getBookById(@PathVariable int id) throws Exception {
		Optional <Book> book = bookService.getBookById(id);
		return  book.orElse(null);
	}
	
	//add a book API end point: http://localhost:8080/api/book/add
	@PostMapping(value="/add",consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> addBook(@RequestBody Book book) throws Exception {
		try{
			bookService.addBook(book);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("The book titled ".concat(book.getName()).concat(" has been successfully added!"));
	}
	
	//update book API end point: http://localhost:8080/api/book/update
	@PutMapping(value="/update",consumes=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> updateBook(@RequestBody Book book) throws Exception{
		try {
			bookService.updateBookById(book);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("The book titled ".concat(book.getName()).concat(" has been successfully updated!"));
	}
	
	//remove book by id API end point: http://localhost:8080/api/book/delete/1
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable int id) throws Exception{
		try {
			bookService.deleteBookById(id);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("The book with id " + id + " has been successfully deleted!");
	}
	
	//get all books API end point: http://localhost:8080/api/book/all
	@GetMapping(value="/all", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	//find books by author API end point: http://localhost:8080/api/book/author?author={author}
	@GetMapping(value="/author", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Book> getBooksByAuthor(@RequestParam("author") String author){
		return bookService.getBooksByAuthor(author);
	}
	
	//find books by genre API end point: http://localhost:8080/api/book/genre?genre={genre}
	@GetMapping(value="/genre", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Book> getBooksByGenre(@RequestParam("genre") String genre){
		return bookService.getBooksByGenre(genre);
	}
	
}
