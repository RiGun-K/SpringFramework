package com.example.anyboard.data;

import javax.persistence.Entity;
import javax.persistence.Table;


/*  JPA �� @Table ���ϸ� ��� ���̺��� ��ҹ��ڷ� ������ 
 *	= ( DB ���̺��̸��� ���� Ŭ���� �̸��� �ٸ��� �������־�� �� )
 *
 *  MyBatis�� �������
 */

@Entity
@Table(name="member")
public class Member {

	// DB �� member ���̺� �� ����
	private String memberId;
	private String password;
	
	// getter setter primarykey �߰�
	// ������ �߰� 
	// �����ֿ� post Ŭ�������� �������� 
}
