package com.akash.demo;

import javax.servlet.Servlet;

import com.akash.demo.model.Book;
import com.akash.demo.thrift.BookService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.demo.thrift.BookServiceHandler;


@EnableAutoConfiguration(exclude={SecurityAutoConfiguration.class})
@ComponentScan
@EntityScan

@EnableMongoAuditing

@SpringBootApplication(scanBasePackages={"com.akash.thrift.BookServiceHandler"})
public class MongobookApplication {
	//private LogUtil logger = LogUtil.createLogger(this.getClass());
	@Autowired
	private BookServiceHandler bookService;
	

	public static void main(String[] args) {
		SpringApplication.run(MongobookApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<Servlet> partAreaServiceVenueServeletRegistration(){
		TProcessor processor = new BookService.Processor<>(bookService);
		TProtocolFactory protocolFactory = new TJSONProtocol.Factory();
		Servlet servlet = new TServlet(processor, protocolFactory);
		//logger.info("Creating Servlet registration bean for Book service");
		ServletRegistrationBean<Servlet> regBean = new ServletRegistrationBean<>(servlet, "/books1/*");
		regBean.setName("Book Server");
		return regBean;

}
}





