package com.example.mylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mylist.data.Crew;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Integer> {

}
