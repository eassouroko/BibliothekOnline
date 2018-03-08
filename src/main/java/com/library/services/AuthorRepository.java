package com.library.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.models.Author;

public interface AuthorRepository  extends JpaRepository<Author,Long>{

}
