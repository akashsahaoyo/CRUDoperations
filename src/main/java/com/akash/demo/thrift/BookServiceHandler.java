package com.akash.demo.thrift;

import java.util.Optional;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.akash.demo.model.Book;
import com.akash.demo.repository.BookRepository;
import com.akash.demo.thrift.BookNotFoundException;

class BookServiceHandler implements BookService.Iface{
	
	
	
	private BookRepository repo;
	
	@Autowired
	
	BookService bookService;
	
	
	
	//private Mybook book;



	@Override
	public String addbook(int id, String bookName, String authorName) throws TException {
		// TODO Auto-generated method stub
	repo.save(id);
	repo.save(bookName);
	repo.save(authorName);
	return "book added with id:"+id;
	}



	@Override
	public Mybook getbook(int id) throws BookNotFoundException, TException {
		// TODO Auto-generated method stub
		Optional<Book> book = repo.findById(id);
		if(book.isPresent()) {
			
			Mybook b=new Mybook();
			//repo.findById(id);
			
			return b.deepCopy();
			
		} else {
			
			throw new BookNotFoundException ("Book Not Found");
		}
		
	}



	@Override
	public String deletebook(int id) throws TException {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Book deleted with id:"+id;
	}

	
	
}