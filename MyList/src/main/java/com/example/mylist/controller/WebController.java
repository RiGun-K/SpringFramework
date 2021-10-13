package com.example.mylist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("title", "¾È³çÇÏ»ì¹ý");
		model.addAttribute("img1", "images/dd.jpg");
		return "index";
	}
}
