package com.example.pracitce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {

	// return ���� /templates/index.html�� ��ȯ
		@GetMapping("/")
		public String index() {
			return "index";
		}
		 
		@GetMapping("/home")
		public String home(Model model) {
			model.addAttribute("title", "�ȳ��ϻ��");
			model.addAttribute("img1", "images/dd.jpg");
			return "home";
		}
		
		@GetMapping("/menus") 
		public String menus() {
			return "menus";
		}
		
		@GetMapping("/crews")
		public String crews() {
			return "crews";
		}
}
