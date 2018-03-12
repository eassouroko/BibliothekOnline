package com.library.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.JoinColumn;  
import javax.persistence.JoinTable;  


@Entity
//@Table(name="Book")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "book_title")
	private String titel;


	@ManyToMany( mappedBy = "authors",targetEntity =com.library.models.Author.class)
	private java.util.Set<Author> authors=new TreeSet<Author>();
	       
	

	public Book() {
		super();
	}
	

	public Book(String titel, Date publicationDate) {
		super();
		this.titel = titel;
		//authors=new TreeSet<Author>();
		
		//this.publicationDate = publicationDate;
	}
	
	
	
	public Set<Author> getAuthors() {
		return authors;
	}


	public void setAuthors( TreeSet<Author> authors) {
		this.authors = authors;
	}
	
	
	
	public int getBookId() {
		return bookId;
	}


	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	
	
	
	public String toString() {
		String value="value";
		return value;
	}

	

}
