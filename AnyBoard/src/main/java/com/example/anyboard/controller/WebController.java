package com.example.anyboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.anyboard.data.Hello;
import com.example.anyboard.data.Result;
import com.example.anyboard.repository.PostRepository;


@Controller
public class WebController {
	
	@Autowired
	PostRepository postRepository;
	
	
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String member() {
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
