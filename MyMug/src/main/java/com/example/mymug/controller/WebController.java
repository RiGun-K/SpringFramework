package com.example.mymug.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	/* 클라이언트에서 요청이 들어오면 (주소로 접속, 이벤트 요청 등)
	 * Controller에서 해당 View에 대한 처리를 한 후 다시 View를 반환한다.
	 */
	
	// return 값인 /templates/index.html을 반환
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "안녕하살법");
		model.addAttribute("img1", "images/dd.jpg");
		return "home";
	}
	
	// Get 과 Post 함수 추가
	@GetMapping("/update")
	public String updateView() {
		return "updatePoint";
	}
	
	// name 이 중요하다고 하셨음
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
		model.addAttribute("userid", userid);
		model.addAttribute("point", 2000);
		return "mypoint";
	}

	
}
