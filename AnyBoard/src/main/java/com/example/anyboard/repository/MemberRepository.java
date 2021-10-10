package com.example.anyboard.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anyboard.data.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
													// <도메인이름, PK 타입>
	
	
	
}
