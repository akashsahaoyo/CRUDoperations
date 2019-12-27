namespace java com.akash.demo.thrift

enum Booktype{
	FICTION,
	DRAMA,
	COMIC
}

struct Mybook{
	1:i32 id;
	2:required string bookName;
	3:string authorName;
}



exception BookNotFoundException{
	1:string errorMessage;
}

exception BadRequest{
	1:string errorMessage;
}

service BookService{
string addbook(1: i32 id,2: string bookName,3: string authorName) ;
Mybook getbook(1: i32 id) throws (1: BookNotFoundException e);
string deletebook(1: i32 id) ;
}  