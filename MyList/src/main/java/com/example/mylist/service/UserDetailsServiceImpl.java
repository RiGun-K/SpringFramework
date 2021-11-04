package com.example.mylist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.mylist.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.example.mylist.data.User> dbuser = userRepository.findById(username);
		if(dbuser.isEmpty()) {
			throw new UsernameNotFoundException("Invalid username");
		}
		
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority("QUERY"));
		if(dbuser.get().getRole().equals("admin"))
			auths.add(new SimpleGrantedAuthority("WRITE"));
		
		UserDetails ud = User
				.withUsername(dbuser.get().getUserid())
				.password(dbuser.get().getPassword())
				.authorities(auths)
				.roles(dbuser.get().getRole())
				.build();
		return ud;
	}

}
