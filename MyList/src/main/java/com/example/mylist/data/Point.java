package com.example.mylist.data;

// RESTful API 는 클래스 단위로 전달됨 ( 데이터용 클래스 )

public class Point {
	private String userid;
	private int value;
	
	public Point() {}
	// 생성자 단축키 : Ctrl + Space
	public Point(String userid, int value) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.value = value;
	}
	
	// Getter,Setter ( 데이터 무결성 유지 )
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
