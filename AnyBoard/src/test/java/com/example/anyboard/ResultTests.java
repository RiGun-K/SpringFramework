package com.example.anyboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.example.anyboard.data.Result;
import com.example.anyboard.repository.ResultRepository;

@SpringBootTest
@Repository
public class ResultTests {

	@Autowired
	ResultRepository resultRepository;
	
	@Test
	void create() {
		Result result = new Result();
		
		//result.setPassword("123");
		
		Result newResult = resultRepository.save(result);
	}
}
