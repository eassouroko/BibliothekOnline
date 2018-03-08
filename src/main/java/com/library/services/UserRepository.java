package com.library.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
