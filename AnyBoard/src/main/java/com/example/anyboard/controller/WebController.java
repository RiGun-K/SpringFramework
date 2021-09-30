package com.example.anyboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "signup";
	}
	
	@GetMapping("/add")
	public String getAdd() {
		return "add";
	}
	
	@GetMapping("/password")
	public String getPassword() {
		return "password";
	}
	
	@GetMapping("/posts")
	public String getPosts() {
		return "posts";
	}
	
	@GetMapping("/posts/{postId}")
	public String getPost(@PathVariable("postId") int postId) {
		return "post";
	}
}
