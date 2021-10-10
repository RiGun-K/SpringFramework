package com.example.anyboard.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// User Ŭ������� �����ϸ� �� ! 

/*  JPA �� @Table ���ϸ� ��� ���̺��� ��ҹ��ڷ� ������ 
 *	= ( DB ���̺��̸��� ���� Ŭ���� �̸��� �ٸ��� �������־�� �� )
 *
 *  MyBatis�� �������
 */

@Entity
@Table(name="member")
public class Member {
	
	// getter setter primarykey �߰�
	// ������ �߰� 
	
	// DB �� member ���̺� �� ����
	@Id
	@Column(length=30)  	// ������ �� �������� 
	private String memberId;
	private String password;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
