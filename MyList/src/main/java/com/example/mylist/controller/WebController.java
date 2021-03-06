package com.example.mylist.controller;

import java.util.Optional;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mylist.data.Crew;
import com.example.mylist.data.Point;
import com.example.mylist.data.User;
import com.example.mylist.mapper.CrewMapper;
import com.example.mylist.repository.MenuRepository;
import com.example.mylist.repository.UserRepository;

@Controller
public class WebController {

	@Autowired
	UserRepository userRepository;
	@Autowired 
	MenuRepository menuRepository;
	
	//
	@Autowired
	CrewMapper crewMapper;
	
	@GetMapping("/crews")
	public String crews(Model model, Principal user) {
//		List<Crew> crews = crewMapper.findAll();
		if(user!=null) System.out.println(user.getName());
		// Mapper 패키지의 객체 가져오기 
		model.addAttribute("crews", crewMapper.findAll());
		return "crews";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titles", "깃허브 연동 완료 ");
		model.addAttribute("img1", "images/dd.jpg");
		return "index";
	}
	
	@GetMapping("/head")
	public String head() {
		return "head";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("username", "hello");
		return "test";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/denied")
	public String denied() {
		return "denied";
	}
	
	@GetMapping("/update")
	public String updateView() {
		return "updatePoint";
	}
	@PostMapping("/update")
	public String updateResult(
			// 입력받은 Input 값을 받아와서 Model 객체로 만듬
			@RequestParam(name="userid") String userid,
			@RequestParam(name="point") int point,
			Model model) {
		model.addAttribute("result", userid + " " + point);
		return "updatePoint";	
	}
	
	// {userid} 값이 DB 내 userid 값과 동일하다면 값을 부여하고 리턴 , 다르면 접속불가 
	@GetMapping("/mypoint/{userid}")
	public String myPoint(@PathVariable("userid") String userid, Model model) {
			Optional<User> user = userRepository.findById(userid);
			if (user.isPresent()) {
				Point p = new Point(userid, user.get().getPoint());
				model.addAttribute("point", p);
			}
			return "mypoint";
	}
	
	@GetMapping("/mypoint")
	public String points(Principal p) {
		if(p!=null)
			return "redirect:mypoint/"+p.getName();
		else
			return "redirect:home";
	}
	
	
	@GetMapping("/adduser")
	public String user() {
		return "addUser";
	}
	
	@GetMapping("/menus")
	public String menus(@RequestParam(required=false) String name, Model model) {
		// 
		if(name==null || name.isEmpty())
			model.addAttribute("menus", menuRepository.findAll());
		else
			model.addAttribute("menus", menuRepository.findByNameContains(name));	
		return "menus";
	}
}
