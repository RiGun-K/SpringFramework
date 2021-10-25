package com.example.anyboard.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private String memberId;
	@Column(length=10)  	// ������ �� �������� 
	private String password;
	private String newPassword;
	
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	Member() {}
	Member(String memberId, String password) {
		this.memberId = memberId;
		this.password = password;
	}
	
	
	

}
