package com.example.mylist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mylist.data.Menu;

@Mapper
public interface MenuMapper {

	public List<Menu> findAll();
	public List<Menu> findByName(String name);
}
