package com.example.anyboard.data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Post {

	// DB �� post ���̺� �� ����
	@ManyToOne(targetEntity=Member.class)
	@JoinColumn(name="memberId")
	Member member;
	
}
