package com.example.mylist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.mylist.data.Crew;

@Mapper
public interface CrewMapper {

	@Select("select * from crew")
	public List<Crew> findAll();
	
	@Select("select * from crew where nickname=#{name}")
	public List<Crew> findByNickname(@Param("name") String name);
}