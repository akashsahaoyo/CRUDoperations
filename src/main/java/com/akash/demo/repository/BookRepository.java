package com.akash.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.demo.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
