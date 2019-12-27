package com.akash.demo.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

//import com.akash.demo.thrift.BookService.Iface;

public class BookServer {
	public static void main(String[] args) {
	try {
	TServerSocket serverTransport = new TServerSocket(8083);
	BookService.Processor processor= new BookService.Processor(new BookServiceHandler());
	TServer server = new TThreadPoolServer(
			new TThreadPoolServer.Args(serverTransport).processor(processor));
	System.out.println("Starting server on port 8083");
	server.serve();
	
	}
	catch(TTransportException e)
	{
		e.printStackTrace();
	}
}
}
