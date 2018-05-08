package com.me.transport.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.me.transport.dao.LoginDao;
import com.me.transport.pojo.Person;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	
	
	private LoginDao logindao = new LoginDao();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Person person = logindao.getUser(username);
		System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getPassword());
		if(person.getUserName() == null) {
			throw new UsernameNotFoundException("User not found");
		} else {
			return new SecurityUser(person);
		}
	}
}
