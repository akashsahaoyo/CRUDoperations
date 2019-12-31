package com.akash.demo.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;


public class BookClient {

	 public static BookService.Client bookClient;
	 
	 
//	 private static Mybook myBook(int id,String bookName, String authorName) {
//		 Mybook book1=new Mybook();
//		 book1.setAuthorName(authorName);
//		 book1.setBookName(bookName);
//		 book1.setId(id);
//		 return book1;
//	 }

	public static void main(String[] args) throws TException {
		int id = 13;
		String bookName="akas";
		String authorName="Ads1";

		// TODO Auto-generated method stub
		String url = "http://localhost:8082/books1/";
		THttpClient tHttpClient = new THttpClient(url);
        tHttpClient.setConnectTimeout(3000);

        TProtocol protocol = new TJSONProtocol(tHttpClient);
        BookClient.bookClient=new BookService.Client(protocol);
//        Mybook book=bookClient.getbook(id);
		//bookClient.addbook(id,bookName,authorName);
		System.out.println(bookClient.getAllbook());
		System.out.println("book added with id "+id);
		System.out.println("Book deleted with id"+id);
	      //bookClient.deletebook(id);
		//System.out.println(bookClient.updatebook(id,bookName,authorName));
      // System.out.println("Book generated here"+bookClient.getbook(id));
        
        
		/*TSocket transport = new TSocket("localhost",8083);
		transport.open();
		TProtocol protocol = new TBinaryProtocol(transport);
		BookService.Client client = new BookService.Client(protocol);
		
		deletion(client, id);
		addbook(client,id,bookName,authorName);
		
		transport.close();*/
	}


/*private static void deletion(BookService.Client client, Integer id) throws TException
{
	
	client.deletebook(id);
}

private static void addbook(BookService.Client client, int id, String bookName, String authorName) throws TException
{
	client.addbook(id, bookName, authorName);
	
}*/

}
