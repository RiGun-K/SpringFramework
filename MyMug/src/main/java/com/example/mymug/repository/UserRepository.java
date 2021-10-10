package com.example.mymug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mymug.data.User;

public interface UserRepository extends JpaRepository<User, String> {


}
