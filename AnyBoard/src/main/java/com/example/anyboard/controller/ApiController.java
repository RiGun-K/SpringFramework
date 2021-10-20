package com.example.anyboard.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anyboard.data.Member;
import com.example.anyboard.data.Post;
import com.example.anyboard.data.Result;
import com.example.anyboard.repository.MemberRepository;
import com.example.anyboard.repository.PostRepository;




@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// 게시글 등록 
	@PostMapping("/posts")
	public Result postPosts(@RequestBody Post post) {
		// 멤버 테이블의 멤버아이디 칼럼이 있는지 없는지 찾아보기 
		Optional<Member> searchedMember = memberRepository.findById(post.getMember().getMemberId());
		if(searchedMember.isPresent()) {
			// 객체끼리 값을 비교 ( 아이디와 비밀번호가 같은지 )
			if(searchedMember.get().getPassword().equals(post.getMember().getPassword())) {
				// 시간칼럼을 가져와서(get) 비었으면, 현재시간 저장(set)
				if(post.getSavedTime()==null)
					post.setSavedTime(LocalDateTime.now());
				// 받은 모든 데이터 저장
				postRepository.save(post);
				return new Result("ok");
				
			} else { // 비번 틀림.
				return new Result("ng");
			}
			
		} else { // 등록되지 않은 사용자.
			return new Result("ng");
		}
	}
	
	
	@DeleteMapping("/posts/{postId}")
	public Result deletePost(@PathVariable(name="postId", required=false) 
			Integer postId,  @RequestBody Member member) {
		if(postId==null) { 
			//url 이 잘못된 경우.
			return new Result("ng");
		}
		Optional<Post> searchedPost = postRepository.findById(postId);
		if(searchedPost.isPresent()) {
			Post post = searchedPost.get();
			// 해당 게시글을 작성한 계정과 입력받은 계정이 일치한가
			if(post.getMember().getMemberId().equals(member.getMemberId()) &&
					post.getMember().getPassword().equals(member.getPassword())) {
				postRepository.deleteById(postId);
				return new Result("ok");
			} else {
				//게시글은 존재하나 작성자의 아이디가 틀렸거나 비밀번호가 틀린 경우 
				return new Result("ng");
			}
		} else // 게시글이 존재하지 않는 경우 - 잘못된 아이디.
			return new Result("ng");
	}

	
	@PostMapping("/signup")
	// 'POST'로 받았으므로 @RequestBody로 Data를 받아온다.
	// public 뒤에, @RequestBody 뒤에는 해당 클래스명
	public Member addMember(@RequestBody Member member) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		memberRepository.save(member);
		return member;
	}
	
	// Put
	@PutMapping("/password")
	public Result putPassword(@RequestBody Member member) {
		// 받아온 데이터.MemberId가 Member테이블에 존재하는지 확인 
		Optional<Member> searchedMember = memberRepository.findById(member.getMemberId());
		
		// 사용자가 존재하는 경우.
		if(searchedMember.isPresent()) {
			// DB에 저장된 그 사용자의 비번과 전달 받은 비번이 같다면 새 비밀번호를 비밀 번호로 저장.
			if(searchedMember.get().getPassword().equals(member.getPassword())) {
				// member 클래스의 Password에 넣어라. (Getter,Setter) 
				member.setPassword(member.getNewPassword());
				// DB에 넣어라 
				memberRepository.save(member);
				return new Result("ok");
			}else {
				// 사용자가 존재해도 기존 비밀 번호를 틀렸다면 저장하지 않음.
				return new Result("ng");
			}
		} else { //해당 아이디를 가진 사용자가 존재하지 않음.
			return new Result("ng");
		}
	}
	
}
