package com.example.mymug.data;

public class Point {
	private String userid;
	private int value;
	
	public Point() {}
	public Point(String userid, int value) {
		this.userid=userid;
		this.value=value;
	}
	
	public String getUserid() { return userid; }
	public void setUserid(String userid) { this.userid = userid; }
	public int getValue() { return value; }
	public void setValue(int value) { this.value = value; }
}
