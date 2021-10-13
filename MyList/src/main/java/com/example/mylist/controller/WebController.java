package com.example.mylist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mylist.data.Point;

@Controller
public class WebController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("title", "깃허브 연동 완료 ");
		model.addAttribute("img1", "images/dd.jpg");
		return "index";
	}
	
	@GetMapping("/update")
	public String updateView() {
		return "updatePoint";
	}
	@PostMapping("/update")
	public String updateResult(
			@RequestParam(name="userid") String userid,
			@RequestParam(name="point") int point,
			Model model) {
		model.addAttribute("result", userid + " " + point);
		return "updatePoint";	
	}
	
	
	@GetMapping("/mypoint/{userid}")
	public String myPoint(@PathVariable("userid") String userid, Model model) {
			Point p = new Point(userid, 3000);
			model.addAttribute("point", p);
			return "mypoint";
	}
	
	
	@GetMapping("/adduser")
	public String user() {
		return "addUser";
	}
}
