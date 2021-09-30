package com.example.anyboard.data;

import javax.persistence.Entity;
import javax.persistence.Table;


/*  JPA 는 @Table 안하면 멤버 테이블이 대소문자로 구분함 
 *	= ( DB 테이블이름과 현재 클래스 이름이 다르면 선언해주어야 함 )
 *
 *  MyBatis는 상관없음
 */

@Entity
@Table(name="member")
public class Member {

	// DB 내 member 테이블 행 선언
	private String memberId;
	private String password;
	
	// getter setter primarykey 추가
	// 생성자 추가 
	// 다음주에 post 클래스까지 만들어오기 
}
