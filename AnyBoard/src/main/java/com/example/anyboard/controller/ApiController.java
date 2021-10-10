package com.example.anyboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anyboard.data.Post;
import com.example.anyboard.data.Result;
import com.example.anyboard.repository.ResultRepository;



@RestController
@RequestMapping("/api")
public class ApiController {
	

	
	@PostMapping("/posts")
	public Result addPost(@RequestBody Post post) {
		
		Result result = new Result();
		return result;
		
		
	}
	
	
}
