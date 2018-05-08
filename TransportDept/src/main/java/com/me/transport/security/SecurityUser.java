package com.me.transport.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.me.transport.pojo.Person;
import com.me.transport.pojo.Role;

public class SecurityUser extends Person implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	public SecurityUser(Person user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Role roles = super.getRole();
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles.toString());
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
