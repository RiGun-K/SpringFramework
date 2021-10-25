package com.example.mylist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylist.data.Menu;
import com.example.mylist.mapper.MenuMapper;

@Service
public class MenuService {
	
	@Autowired
	public MenuMapper menuMapper;
	
	public List<Menu> findAllMenu() {
		return menuMapper.findAll();
	}
	
	public List<Menu> findMenuByName(String name) {
		return menuMapper.findByName(name);
	}
}
