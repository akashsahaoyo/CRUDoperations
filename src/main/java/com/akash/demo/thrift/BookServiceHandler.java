package com.akash.demo.thrift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akash.demo.model.Book;
import com.akash.demo.repository.BookRepository;

@Service
public class BookServiceHandler implements BookService.Iface{
	
	
	@Autowired
	private BookRepository repo;

	@Override
	public String addbook(int id, String bookName, String authorName) throws BadRequestException, TException {
		Book b1=new Book();

		if(repo.findById(id).isPresent()) {
			throw new BadRequestException("Duplicate id");

		}
		else {
			if(bookName.isEmpty() || authorName.isEmpty()){
				throw new BadRequestException("Null values");
			}
			else {
				b1.setAuthorName(authorName);
				b1.setId(id);
				b1.setBookName(bookName);


				repo.save(b1);

				return "book added with id:" + id;
			}
		}
	}

	@Override
	public Mybook getbook(int id) throws BookNotFoundException, TException {
		Optional<Book> book = repo.findById(id);
		if(book.isPresent()) {
			Book dbBook = book.get();
			Mybook b=new Mybook();
			b.setAuthorName(dbBook.getAuthorName());
			b.setBookName(dbBook.getBookName());
			b.setId(dbBook.getId());
			//repo.findById(id);

			return b;

		} else {

			throw new BookNotFoundException("Book Not Found");
		}
	}

	@Override
	public String deletebook(int id) throws BadRequestException, TException {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return "Book deleted with id:"+id;}
		else {
			throw new BadRequestException("Id dont exist");
		}
	}

	@Override
	public String updatebook(int id, String bookName, String authorName) throws BadRequestException, TException {
		Book b1=new Book();

		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			b1.setAuthorName(authorName);
			b1.setId(id);
			b1.setBookName(bookName);


			repo.save(b1);

			return "book added with id:"+id;


		}
		else {
			throw new BadRequestException("Duplicate id");

		}
	}

@Override
	public String getAllbook() throws TException {
		List<Book> b=new ArrayList<>();
		

		b=repo.findAll(Sort.by("id"));

		return b.toString();
	//Arrays.toString(b);










	}




	/*

	@Override
	public String addbook(int id, String bookName, String authorName) throws com.akash.demo.thrift.backup.BadRequestException, TException {
		// TODO Auto-generated method stub
		Book b1=new Book();

		if(repo.findById(id).isPresent()) {
			throw new com.akash.demo.thrift.backup.BadRequestException("Duplicate id");
		
		}
		else {
			
			b1.setAuthorName(authorName);
			b1.setId(id);
			b1.setBookName(bookName);
		
		
		repo.save(b1);
		
		return "book added with id:"+id;
		}
	}

	@Override
	public com.akash.demo.thrift.backup.Mybook getbook(int id) throws com.akash.demo.thrift.backup.BookNotFoundException, TException {
		// TODO Auto-generated method stub
		Optional<Book> book = repo.findById(id);
		if(book.isPresent()) {
			Book dbBook = book.get();
			com.akash.demo.thrift.backup.Mybook b=new Mybook();
			b.setAuthorName(dbBook.getAuthorName());
			b.setBookName(dbBook.getBookName());
			b.setId(dbBook.getId());
			//repo.findById(id);
			
			return b;
			
		} else {
			
			throw new BookNotFoundException("Book Not Found");
		}
		
	}

	@Override
	public String deletebook(int id) throws com.akash.demo.thrift.backup.BadRequestException, TException {
		// TODO Auto-generated method stub
		if(repo.findById(id).isPresent()) {
		repo.deleteById(id);
		return "Book deleted with id:"+id;}
		else {
			throw new BadRequestException("Id dont exist");
		}
	}*/


	
	

	
	
}