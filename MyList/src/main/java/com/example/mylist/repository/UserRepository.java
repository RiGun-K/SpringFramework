package com.example.mylist.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mylist.data.User;

// DB에 CRUD 명령어 작성하는 곳 
/*
 * Select => find 
 * Insert => save
 * Delete => delete
 * Where  => By + 칼럼 이름
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {



	

}
