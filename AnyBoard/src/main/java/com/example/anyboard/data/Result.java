package com.example.anyboard.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="result")
public class Result {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String title;
	@Column
	private int password;
	
	
	
	
	
	

	
	
}
