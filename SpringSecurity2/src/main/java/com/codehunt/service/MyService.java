package com.codehunt.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codehunt.entity.User;
import com.codehunt.repo.UserRepository;
import com.codehunt.userdetail.UserDetailImpl;

@Service
public class MyService  implements UserDetailsService{

	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =null;
		Optional<User> byEmail = repo.findByEmail(username);
		
		if(byEmail.isPresent()) {
			user= byEmail.get();
			return new UserDetailImpl(user);
		}
		
		else {
			return null;
		}
	
	}

	
}
