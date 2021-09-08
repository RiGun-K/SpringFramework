package com.example.mymug.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mymug.data.Point;

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
	// 입력받은 userid point 값을 객체로 만든후 addAttribute 하여 View에 반환  
	@PostMapping("/update")
	public String updateResult(
			@RequestParam(name="userid") String userid,
			@RequestParam(name="point") int point,
			Model model) {
		model.addAttribute("result", userid + "와" + point);
		return "updatePoint";
	}
	
	// 주소창의 userid 값을 받아와서 이 값을 String형 Model 객체로 만든다.
	// 이 userid 객체를 View로 이동시킨다 
	@GetMapping("/mypoint/{userid}")
	public String myPoint(@PathVariable("userid") String userid, Model model) {
		Point p = new Point(userid, 2000);
		model.addAttribute("point", p);
		
//		model.addAttribute("userid", userid);
//		model.addAttribute("point", 2000);
		return "mypoint";
	}

	
}
