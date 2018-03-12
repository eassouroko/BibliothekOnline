package com.library.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

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

import org.hibernate.mapping.List;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
//@Table(name="Author")
public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	@Column(name = "author_name")
	private String name;
	
	@Column(name = "author_email")
	private String mail;

	@ManyToMany(cascade= CascadeType.ALL)
	    @JoinTable(name = "Author_has_Book",
	        joinColumns = @JoinColumn(name = "authorId"),
	        inverseJoinColumns = @JoinColumn(name = "bookId")
	    )



	private java.util.Set<Book> books;	
	
	public Author() {
		super();
	}
	
	
	public Author(String name, String mail) {
		super();
		this.name = name;
		
		this.mail = mail;
		books=new TreeSet<Book>();
		
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
