package com.example.mylist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mylist.data.Point;
import com.example.mylist.data.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// RestController = View 가 아닌 Data 나 객체를 반환
	
	// JSON 객체로 반환 =  {"userid" : "?", "value" : "?"}
	// public 뒤에는 클래스명과 동일하게 = Point
	@GetMapping("/mypoint/{userid}")
	public Point getPoint(@PathVariable("userid") String userid) {
		Point point = new Point(userid, 5000);
		return point;
	}
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		return user;
	}
	
}
