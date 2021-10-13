package com.example.mylist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("title", "깃허브 연동 완료 ");
		model.addAttribute("img1", "images/dd.jpg");
		return "index";
	}
}
