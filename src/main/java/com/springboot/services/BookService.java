package com.springboot.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.entities.Book;

@Service // or we can use @Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	/*
	 * static {
	 * 
	 * list.add(new Book("The Complete Reference C", 101, "Brook")); list.add(new
	 * Book("The Complete Reference C#", 102, "Alan")); list.add(new
	 * Book("The Complete Reference Java", 103, "Robert")); list.add(new
	 * Book("The Complete Reference Python", 104, "Subramanyam")); list.add(new
	 * Book("The Complete Reference PHP", 105, "Nagarjun")); list.add(new
	 * Book("The Complete Reference C++", 106, "Kumar")); list.add(new
	 * Book("The Complete Reference Scala", 107, "Peter"));
	 * 
	 * }
	 */

	// service for getting all the books
	public List<Book> getAllBooks() {
		return list;
	}

	// service for getting single book by id
	public Book getBookbyId(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	// service for adding a book
	public Book addBook(Book b) {

		list.add(b);
		System.out.println(b);
		return b;
	}

	// service for deleting a book
	public void deleteBook(int id) {
		list = list.stream().filter(book -> book.getBookId() != id).collect(Collectors.toList());
	}

	// Service for updating the book
	public void updateBook(Book book, int bookId) {
		list.stream().map(b -> {
			if (b.getBookId() == bookId) {
				b.setBookAuthor(book.getBookAuthor());
				b.setBookName(book.getBookName());
			}
			return b;
		}).collect(Collectors.toList());
	}

	public List<Book> addAllBooks(List<Book> booksList) {
		for (Book book : booksList) {
			list.add(book);
			System.out.println(list);
		}
		return list;
		
		

	}
}