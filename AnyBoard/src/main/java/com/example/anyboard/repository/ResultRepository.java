package com.example.anyboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anyboard.data.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, String> {

	
	public static void create() {
		Result result = new Result();
		
		result.setPassword("!23");
		
		Result result = ResultRepository.save(result);
		
	}
	
}
