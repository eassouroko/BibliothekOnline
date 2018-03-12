package com.library.services;

import java.util.ArrayList;

//import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.models.Book;

public interface BookRepository extends CrudRepository<Book,Long>{
	


}
