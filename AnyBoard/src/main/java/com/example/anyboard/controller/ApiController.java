package com.example.anyboard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anyboard.data.Post;
import com.example.anyboard.data.Result;


@RestController
@RequestMapping("/api")
public class ApiController {
	
	@PostMapping("/posts")
	public Result addPost(@RequestBody Post post) {
		
		Result result = new Result("ok");
		return result;
		
		
	}
}
