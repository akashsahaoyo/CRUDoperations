package com.akash.demo.repository;

import com.akash.demo.thrift.Mybook;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.demo.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

	void save(Mybook book);

	void save(long id);

	void save(String bookName);
	
	

}
