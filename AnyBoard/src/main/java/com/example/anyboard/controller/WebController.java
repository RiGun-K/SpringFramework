package com.example.anyboard.controller;

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


@Controller
public class WebController {

	@GetMapping("/hello-mvc")
	public String helloMvc(@RequestParam("name") String ok, Model model) {
		model.addAttribute("name", ok);
		return "hello-template";
		
		// @RequestParam 으로 ${name}을 받아와서 Model 화 시킨후 
		// addAttribute 로 지정한 그 값을 받아와서 Html 로 반환한다.
		
		// Get 방식으로 '?' 로 파라미터를 넘겨준다. 
		// = localhost/hello-mvc?name={ ... } 
	}
	
	@GetMapping("/hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("/hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello(name);
//		hello.setName(name);
		return hello;
		
		// 'hello' 라는 객체 생성
		
		// Hello 클래스를 Data 패키지에 생성하여 불러왔음.
		 
		// 여기에 static class ??? 하여서 쓸 수도 있음 
	}
	
	
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
