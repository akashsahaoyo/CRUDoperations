package com.akash.demo.repository;

import com.akash.demo.thrift.Mybook;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.demo.model.Book;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, Integer>{

	void save(Mybook book);

	void1 saved(String bookName);
	void save(long id);

	void save(String bookName);
	
	@Query("{'bookName':{$regex: '^A.*'}}")
	public List<Book> bookstartingwithA();

	@Query("{'id':{$gte: 19}}")
	public List<Book> booksgreaterthannumber();


}
