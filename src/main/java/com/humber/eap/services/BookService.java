package com.humber.eap.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.eap.model.Book;
import com.humber.eap.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// get book by id
	public Optional<Book> getBookById(int id) throws Exception {
		return bookRepository.findById(id);
	}

	// add a book
	public void addBook(Book book) throws Exception {
		boolean isExist = bookRepository.findAll().stream().anyMatch(b -> b.getName() == book.getName());
		if (isExist)
			throw new Exception("The book titled " + book.getName()
					+ " already exists in the database. Please try a adding a new book!");
		bookRepository.save(book);
	}

	// update a book
	public void updateBook(Book book) throws Exception {
		boolean isExist = bookRepository.findAll().stream().anyMatch(b -> b.getName().equals(book.getName()));
		if (!isExist)
			throw new Exception("The book titled " + book.getName() + " doesn't exist in the database.");
		bookRepository.save(book);
	}

	// remove a book by id
	public void deleteBookById(int id) throws Exception {
		boolean isExist = bookRepository.findAll().stream().anyMatch(b -> b.getId() == id);
		if (!isExist)
			throw new Exception("The book with id " + id + " doesn't exist in the database.");
	}

	// get all books
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// find books by author
	public List<Book> getBooksByAuthor(String author) {
		return bookRepository.findAll().stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
	}

	// find books by genre
	public List<Book> getBooksByGenre(String genre) {
		return bookRepository.findAll().stream().filter(b -> b.getGenre().equals(genre)).collect(Collectors.toList());
	}
}
