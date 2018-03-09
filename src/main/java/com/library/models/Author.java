package com.library.models;
import java.io.Serializable;
import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author{
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "author_name")
	private String name;
	
	@Column(name = "author_email")
	private String mail;

	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "post_tag",
	        joinColumns = @JoinColumn(name = "author_id"),
	        inverseJoinColumns = @JoinColumn(name = "book_id")
	    )
	
	private ArrayList<Book> books; 
	
	public Author() {
		super();
	}
	
	
	public Author(String name, String mail) {
		super();
		this.name = name;
		
		this.mail = mail;
	}
	  
    public ArrayList<Book> getBooks()  {
		return books;
	}
	 public void setBooks(ArrayList<Book> books)  
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
	public String toString() {
		return "Author Name:"+name;
	}
}
