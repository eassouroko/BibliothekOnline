package com.library.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.models.Author;
@Repository

public interface AuthorRepository  extends JpaRepository<Author,Long>{

}
