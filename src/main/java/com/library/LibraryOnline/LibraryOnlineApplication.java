package com.library.LibraryOnline;


import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.library.models.*;
import com.library.services.AuthorRepository;
import com.library.services.BookRepository;
import com.library.services.UserRepository;
@ComponentScan("com.library")
@SpringBootApplication
public class LibraryOnlineApplication {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	
 

	public static void main(String[] args) {
		SpringApplication.run(LibraryOnlineApplication.class, args);
	}
	
	@Transactional
	
	public void run(String... arg0) throws Exception {
		//Adding a book and its author or authors
		
		Book book1= new Book();
		
		book1.setTitel("Book1");
		
		book1.setPublicationDate(Date.valueOf("2000-11-01"));
		Book book2= new Book();
		book2.setTitel("Book2");
		book2.setPublicationDate(Date.valueOf("1999-05-22"));
		
		Author jack = new Author();
		jack.setName("Jack Lang");
		jack.setMail("lang@example.com");
		Author peter = new Author();
		peter.setName("Peter Great");
		peter.setMail("great@united.net");
		
		Set<Author> authorsBook1 = new HashSet<Author>();
		authorsBook1.add(jack);
		authorsBook1.add(peter);
		book1.setAuthors(authorsBook1);
		bookRepository.save(book1);
		
		
		Set<Author> authorsBook2 = new HashSet<Author>();
		authorsBook2.add(jack);
		book2.setAuthors(authorsBook2);
		bookRepository.save(book2);
		
		Set<Book> booksofAuthor =new HashSet<Book>();
		booksofAuthor.add(book1);
		booksofAuthor.add(book2);
		jack.setBooks(booksofAuthor);
		authorRepository.save(jack);
		booksofAuthor =new HashSet<Book>();
		booksofAuthor.add(book1);
		peter.setBooks(booksofAuthor);
		authorRepository.save(peter);
		
		
		
		List<Book> bookLst = bookRepository.findAll();
		List<Author> authorLst = authorRepository.findAll();
		
		System.out.println(bookLst.size());
		System.out.println(authorLst.size());
		
		
		System.out.println("===================Students info:==================");
		bookLst.forEach(student->System.out.println(student.toString()));
		
		System.out.println("===================Students info:==================");
		authorLst.forEach(subject->System.out.println(subject.toString()));
	}
}
