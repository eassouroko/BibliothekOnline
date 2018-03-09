package com.library.LibraryOnline;


import java.sql.Date;
import java.util.ArrayList;


//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.library.models.*;
import com.library.services.AuthorRepository;
import com.library.services.BookRepository;


@SpringBootApplication
@ComponentScan("com.library")
public class LibraryOnlineApplication implements CommandLineRunner {
	
	
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	
 

	public static void main(String[] args) {
		SpringApplication.run(LibraryOnlineApplication.class, args);
	}
	
	@Override
	//@Transactional
	public void run(String... arg0) throws Exception {
		//Adding a book and its author or authors
		System.out.println("===================Adding object to DB:==================");
		Book book1= new Book();
		
		book1.setTitel("Book1");
		
		book1.setPublicationDate(Date.valueOf("2000-11-01"));
		Book book2= new Book();
		book2.setTitel("Book2");
		book2.setPublicationDate(Date.valueOf("1999-05-22"));
		System.out.println("+++++++++++++++++++++");
		System.out.println(book1.getTitel()+" "+book2.getTitel());
		System.out.println("+++++++++++++++++++++");
		
		Author jack = new Author();
		jack.setName("Jack Lang");
		jack.setMail("lang@example.com");
		System.out.println("++++++++ HIER KOMMT DER JACK+++++++++++++");
		System.out.println(jack.toString());
		System.out.println("+++++++++++++++++++++");
		
		
		Author peter = new Author();
		peter.setName("Peter Great");
		peter.setMail("great@united.net");
		System.out.println("++++++++++HIER KOMMT PETER+++++++++++"+ peter.toString());
		// ArrayList<Author> authorsBook1 = new  ArrayList<Author>();
		//authorsBook1.add(jack);
		//authorsBook1.add(peter);
	//	System.out.println("++++++++++Number of author+++++++++++"+ authorsBook1.size());
//		book1.setAuthors(authorsBook1);
		  System.out.println("++++++++++Saved book+++++++++++ "+ book1.getTitel());
		bookRepository.save(book1);
     //   System.out.println("++++++++++Number of author+++++++++++"+ book1.getAuthors().size());
		
		
//		ArrayList<Author> authorsBook2 = new  ArrayList<Author>();
//		authorsBook2.add(jack);
//		book2.setAuthors(authorsBook2);
//		bookRepository.save(book2);
//		
//		 ArrayList<Book> booksofAuthor =new  ArrayList<Book>();
//		booksofAuthor.add(book1);
//		booksofAuthor.add(book2);
//		jack.setBooks(booksofAuthor);
//		authorRepository.save(jack);
//		booksofAuthor =new  ArrayList<Book>();
//		booksofAuthor.add(book1);
//		peter.setBooks(booksofAuthor);
//		authorRepository.save(peter);
		
		
		
//		List<Book> bookLst = bookRepository.findAll();
//		List<Author> authorLst = authorRepository.findAll();
//		
//		System.out.println(bookLst.size());
//		System.out.println(authorLst.size());
//		
//		
//		System.out.println("===================Students info:==================");
//		bookLst.forEach(student->System.out.println(student.toString()));
//		
//		System.out.println("===================Students info:==================");
//		authorLst.forEach(subject->System.out.println(subject.toString()));
	}
}
