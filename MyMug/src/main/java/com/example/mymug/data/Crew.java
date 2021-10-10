package com.example.mymug.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crew")
public class Crew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int crewid;
	@Column(nullable = false, length = 100)
	private String nickname;
	@Column(nullable = false, length = 100)
	private String name;
	
	public Crew(){}
	public Crew(int crewid, String nickname, String name) {
		this.crewid = crewid;
		this.nickname = nickname;
		this.name = name;

	}
	
	public int getCrewid() { return crewid; }
	public void setCrewid(int crewid) { this.crewid = crewid; }
	public String getNickname() { return nickname; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
