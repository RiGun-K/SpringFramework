package com.example.anyboard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.anyboard.data.Result;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@PostMapping("/posts")
	public Result addPost(@RequestBody Post post) {
		return new Result("ok");
	}
}
