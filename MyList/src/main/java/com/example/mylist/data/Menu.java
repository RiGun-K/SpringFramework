package com.example.mylist.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="menu")
@Getter
@Setter
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int menuid;
	
	@Column(nullable=false, length=100)
	private String name;
	@Column
	private int price;
	
	// 직원-메뉴 는 1:N 관계이며 FK를 가진다.
	// Menu 클래스에 crew 변수를 추가한다. ( Menu 테이블에 'crew' FK 칼럼 추가됨 )
	@ManyToOne(targetEntity=Crew.class)
	@JoinColumn(name="crew")
	private Crew crew;
	
	public Menu(){}
	public Menu(int menuid, String name, int price) {
		this.menuid = menuid;
		this.name = name;
		this.price = price;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Crew getCrew() {
		return crew;
	}
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	
	
}
