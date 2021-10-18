package com.example.mylist.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="crew")
@Getter
@Setter
public class Crew {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// DB에 PK 값을 자동으로 생성하도록 설정 ( 1,2,3, ... )
	private int crewid;
	
	@Column(nullable=false, length=100)
	private String nickname;
	@Column(nullable=false, length=100)
	private String name;
	
	// 직원을 조회하면서 직원의 모든 메뉴를 조회하는 경우
	@OneToMany
	@JoinColumn(name="crew")
	private List<Menu> menus;
}
