package com.board.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.board.dto.LoginDto;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;

	private LoginDto users;

	public SecurityUser(LoginDto users) {

		super(users.getUserId(), users.getUserPassword(),
				AuthorityUtils.createAuthorityList(users.getUserrole().toString()));
		System.out.println("사용자 정보: " + users);
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginDto getUsers() {
		return users;
	}

}
