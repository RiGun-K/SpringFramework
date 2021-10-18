package com.example.anyboard.data;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name="post")
public class Post {

	// DB �� post ���̺� �� ����
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	private String title;
	private String body;
	private LocalDateTime savedTime;	// �ð�,�������� Ŭ���� (�ð�,������ �������) 
	
	@ManyToOne(targetEntity=Member.class)
	@JoinColumn(name="memberId")
	private Member member;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getSavedTime() {
		return savedTime;
	}

	public void setSavedTime(LocalDateTime savedTime) {
		this.savedTime = savedTime;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	


	

	
	
}
