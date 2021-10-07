package com.example.anyboard.data;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

	// DB 내 post 테이블 행 선언
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	private String title;
	private String body;
	private LocalDateTime savedTime;	// 각각의 
	
	@ManyToOne(targetEntity=Member.class)
	@JoinColumn(name="memberId")
	private Member member;
	
}
