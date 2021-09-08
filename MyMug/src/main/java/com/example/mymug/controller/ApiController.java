package com.example.mymug.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mymug.data.Point;
import com.example.mymug.data.User;


@RestController
@RequestMapping("/api")
public class ApiController {
	@GetMapping("/mypoint/{userid}")
	public Point getPoint(@PathVariable("userid") String userid) {
		Point point = new Point(userid, 3000);
		return point;
	}
	
@PostMapping("/adduser")
public User addUser(@RequestBody User user) {
	// 나중에 DB코드 추가
	return user;
}



}
