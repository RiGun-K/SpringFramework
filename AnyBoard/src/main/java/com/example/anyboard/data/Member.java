package com.example.anyboard.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// User 클래스라고 생각하면 됨 ! 

/*  JPA 는 @Table 안하면 멤버 테이블이 대소문자로 구분함 
 *	= ( DB 테이블이름과 현재 클래스 이름이 다르면 선언해주어야 함 )
 *
 *  MyBatis는 상관없음
 */

@Entity
@Table(name="member")
public class Member {
	
	// getter setter primarykey 추가
	// 생성자 추가 
	
	// DB 내 member 테이블 행 선언
	@Id
	@Column(length=30)  	// 데이터 값 길이조정 
	private String memberId;
	private String password;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
