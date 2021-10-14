package com.example.mylist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mylist.data.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	public List<Menu> findByNameContains(String name);

}
