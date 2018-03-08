package com.library.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;  
import javax.persistence.JoinTable;  




@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "book_title")
	private String titel;

	@Column(name = "book_publication_date")
	private Date publicationDate;
	private Set<Author> authors;
	private Set<User> users;
	

	public Book() {
		super();
	}
	

	public Book(String titel, Date publicationDate) {
		super();
		this.titel = titel;
		this.publicationDate = publicationDate;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="author_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="author_id"))  
	
	
    
	public Set<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	
	public Set<User> getUsers(){
		
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users=users;
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
