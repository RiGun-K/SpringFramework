package com.example.anyboard.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
import com.example.anyboard.repository.PostRepository;
import com.example.anyboard.repository.ResultRepository;




@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@PostMapping("/posts")
	public Result postPosts(@RequestBody Post post) {
		Optional<Member> searchedMember = memberRepository.findById(post.getMember().getMemberId());
		if(searchedMember.isPresent()) {
			if(searchedMember.get().getPassword().equals(post.getMember().getPassword())) {
				if(post.getSavedTime()==null)
					post.setSavedTime(LocalDateTime.now());
				postRepository.save(post);
				return new Result("ok");
				
			} else { // 비번 틀림.
				return new Result("ng");
			}
			
		} else { // 등록되지 않은 사용자.
			return new Result("ng");
		}
	}

	
	@PostMapping("/signup")
	public Member addMember(@RequestBody Member member) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		memberRepository.save(member);
		return member;
	}
	
	
}
