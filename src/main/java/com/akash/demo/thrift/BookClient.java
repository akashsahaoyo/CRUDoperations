package com.akash.demo.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import com.akash.demo.repository.BookRepository;


public class BookClient {

	public static void main(String[] args, Integer id, String bookName, String authorName) throws TException {
		// TODO Auto-generated method stub
		
		TSocket transport = new TSocket("localhost",8083);
		transport.open();
		TProtocol protocol = new TBinaryProtocol(transport);
		BookService.Client client = new BookService.Client(protocol);
		
		deletion(client, id);
		addbook(client,id,bookName,authorName);
		
		transport.close();
	}


private static void deletion(BookService.Client client, Integer id) throws TException
{
	
	client.deletebook(id);
}

private static void addbook(BookService.Client client, int id, String bookName, String authorName) throws TException
{
	client.addbook(id, bookName, authorName);
	
}

}
