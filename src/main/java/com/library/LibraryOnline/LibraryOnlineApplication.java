package com.library.LibraryOnline;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.library.models.*;
import com.library.services.AuthorRepository;

import com.library.services.BookRepository;



@SpringBootApplication
@EnableJpaRepositories("com.library.services")
@ComponentScan("com.library")
@EntityScan("com.library.models")
public class LibraryOnlineApplication implements CommandLineRunner {
	
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(LibraryOnlineApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		//Adding a book and its author or authors
		System.out.println("===================Adding object to DB:==================");
		Book book1= new Book();
		
		book1.setTitel("Book1");
		
		//book1.setPublicationDate(Date.valueOf("2000-11-01"));
		Book book2= new Book();
		book2.setTitel("Book2");
		//book2.setPublicationDate(Date.valueOf("1999-05-22"));
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
		book1.getAuthors().add(peter);
		book1.getAuthors().add(jack);
		
		System.out.println("++++++++++Saved book+++++++++++ "+ book1.getTitel());
		bookRepository.save(book1);
        System.out.println("++++++++++Number of author+++++++++++"+ book1.getAuthors().size());
		
		book2.getAuthors().add(jack);
		
		bookRepository.save(book2);

	}
}
