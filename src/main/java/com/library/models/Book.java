package com.library.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import javax.persistence.JoinColumn;  
//import javax.persistence.JoinTable;  


@Entity
@Table(name = "book")
public class Book{
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "book_title")
	private String titel;

	@Column(name = "book_publication_date")
	private Date publicationDate;
	@ManyToMany(mappedBy = "books")
	private ArrayList<Author> authors;

	
	

	public Book() {
		super();
	}
	

	public Book(String titel, Date publicationDate) {
		super();
		this.titel = titel;
		this.publicationDate = publicationDate;
	}
	
	
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}


	public void setAuthors( ArrayList<Author> authors) {
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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}


	
	
	public String toString() {
		String value="value";
		return value;
	}

	

}
