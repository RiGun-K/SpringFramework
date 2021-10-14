package com.example.anyboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anyboard.data.Member;
import com.example.anyboard.data.Post;
import com.example.anyboard.data.Result;
import com.example.anyboard.repository.MemberRepository;
import com.example.anyboard.repository.ResultRepository;




@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@PostMapping("/posts")
	public Result addPost(@RequestBody Post post) {
		
		Result result = new Result();
		return result;	
	}
	
	@PostMapping("/signup")
	public Member addMember(@RequestBody Member member) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		memberRepository.save(member);
		return member;
	}
	
	
}
