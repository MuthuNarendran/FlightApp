package com.apigateway.springsecurity.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if ("muthu".equals(username)) {
//				return new User("mark", "{noop}mark@123", new ArrayList<>());
			return new User("muthu", "$2a$09$LVyPgYHViIJJvyjoUCgEwOZQEUACE06MK9IvkyafY4qMHKqiI7pS6", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
