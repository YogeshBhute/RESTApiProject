package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	 

}
