package com.example.mymug.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuid;
	@Column(nullable = false, length = 100)
	private String name;
	@Column
	private int price;
	
	@ManyToOne(targetEntity = Crew.class)
	@JoinColumn(name="crew")
	private Crew crew;
	
	@OneToMany
	@JoinColumn(name="crew")
	private List<Menu> menus;
	
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

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}


}
