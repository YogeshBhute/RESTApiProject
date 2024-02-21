package com.springboot.controller;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.entities.Book;
import com.springboot.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ResponseBody // to directly return the string "My First Book", as no view (html, jsp page) is created
	public String getBook() {
		return "My First Book";
	}
	
	// No need to use @RequestMapping(value="/books", method = RequestMethod.GET)
	// if used @GetMapping and @RestController (instead of only @Controller)

	@GetMapping(value = "/bookGetMapping")
	public Book getBookWithGetMapping() {
		Book book = new Book();
		book.setBookId(101);
		book.setBookAuthor("Denis");
		book.setBookName("C Programming");
		System.out.println(book);
		return book;
	}

	// handler service for getting all books
	@GetMapping(value = "/allbooks")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					
		}
		return ResponseEntity.of(Optional.of(list));
	}

	// handler service for getting single book by Id
	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> getSingleBookbyId(@PathVariable("id") int id) {
		Book book = bookService.getBookbyId(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// handler service for adding a book
	@PostMapping(value = "/addbook")
	public Book addOneBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		System.out.println(book);
		return b;
	}
	
	@PostMapping(value = "/addAllBooks")
	public Book addAllBooks(@RequestBody List<Book> books) {
		List<Book> b = this.bookService.addAllBooks(books);
		System.out.println(books);
		return (Book) b;
	}
	
		
	// handler service for deleting a book
	@DeleteMapping(value = "/delbook/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}

	// handler service for updating a book
	@PutMapping(value = "/updatebook/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book, bookId);
		return book;
	}
}
