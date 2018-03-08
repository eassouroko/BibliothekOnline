package com.library.models;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "author_name")
	private String name;
	
	@Column(name = "author_email")
	private String mail;

	private Set<Book> books;  
	public Author() {
		super();
	}
	
	
	public Author(String name, String mail) {
		super();
		this.name = name;
		
		this.mail = mail;
	}
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="authors")  
    public Set<Book> getBooks()  {
		return books;
	}
	 public void setBooks(Set<Book> books)  
	    {  
	        this.books = books;  
	    }  

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
