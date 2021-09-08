package com.example.mymug.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	/* Ŭ���̾�Ʈ���� ��û�� ������ (�ּҷ� ����, �̺�Ʈ ��û ��)
	 * Controller���� �ش� View�� ���� ó���� �� �� �ٽ� View�� ��ȯ�Ѵ�.
	 */
	
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
	
	// Get �� Post �Լ� �߰�
	@GetMapping("/update")
	public String updateView() {
		return "updatePoint";
	}
	
	// name �� �߿��ϴٰ� �ϼ���
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
