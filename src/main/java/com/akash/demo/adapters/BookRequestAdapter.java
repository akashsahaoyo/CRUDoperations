package com.akash.demo.adapters;



import com.akash.demo.model.Book;
import com.akash.demo.utils.LogUtil;

final public class BookRequestAdapter {

	
	private static LogUtil logger = LogUtil.createLogger(BookRequestAdapter.class);

    private BookRequestAdapter(){}

    public static Book parseData(String addbook, String authorName, int id, String bookName){
        logger.debug("ParseData(Add) method call :: input = "+addbook);

        Book parsedBook = new Book();
        parsedBook.setAuthorName(authorName);
        parsedBook.setBookName(bookName);
        parsedBook.setId(id);

        logger.debug("ParseData(Add) method call :: output = "+parsedBook);
        return parsedBook;
    }

  
	
}
