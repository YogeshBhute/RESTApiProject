package com.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books ")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "book_id")
	private int bookId;
	
	@Column(name= "book_name")
	private String bookName;
	
	@Column(name= "book_author")
	private String bookAuthor;

	public Book() { super(); }
	
	public Book(String bookName, int bookId, String bookAuthor) {
		this.bookName = bookName;
		this.bookId = bookId;
		this.bookAuthor = bookAuthor;
	}

	@Override
	public String toString() {
		return "Book [Book Name=" + bookName + ", Book Id=" + bookId + ", Book Auther=" + bookAuthor + "]";
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}
