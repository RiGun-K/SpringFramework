package com.example.anyboard.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.anyboard.data.Hello;
import com.example.anyboard.data.Post;
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
	public String getPosts(Model model) {
		// 최신순
		model.addAttribute("posts", postRepository.findAll(Sort.by(Sort.Direction.DESC, "savedTime")));
		return "posts";
	}
	
	@GetMapping("/posts/{postId}")
	public String getPost(@PathVariable("postId") int postId, Model model) {
		// 주소창의 postId 값이 <Post> 에 있는가 
		Optional<Post> searchedPost = postRepository.findById(postId);
		if(searchedPost.isPresent()) {
			model.addAttribute("post", searchedPost.get());
		}
		return "post";
	}
	
	
}
