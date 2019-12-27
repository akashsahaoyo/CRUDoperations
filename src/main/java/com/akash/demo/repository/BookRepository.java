package com.akash.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.demo.model.Book;
import com.akash.demo.thrift.Mybook;

public interface BookRepository extends MongoRepository<Book, Integer>{

	void save(Mybook book);

	void save(long id);

	void save(String bookName);

}
