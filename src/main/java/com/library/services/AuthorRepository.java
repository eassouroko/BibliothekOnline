package com.library.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.models.Author;


public interface AuthorRepository  extends CrudRepository<Author,Long>{
	

}
