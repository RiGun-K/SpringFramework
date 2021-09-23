package com.example.mymug.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	private String userid;
	@Column(nullable=false, length=100)
	private String name;
	private int point;
	
	public User(){}
	public User(String userid, String name) {
		this.userid = userid;
		this.name = name;
	}
	
	public String getUserid() { return userid; }
	public void setUserid(String userid) { this.userid = userid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; } 
	public int getPoint() { return point; }
	public void setPoint(int point) { this.point = point; }
	
}
