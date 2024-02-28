package com.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.board.dao.LoginDao;
import com.board.dto.LoginDto;

@Service
public class LoginUserService implements UserDetailsService {

	@Autowired
	private LoginDao Dao;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		LoginDto user = Dao.findById(userId);
		
		if (user == null) {
			System.out.println("사용자 없음");
			throw new UsernameNotFoundException(userId + " 사용자 없음");
		} else {
			return new SecurityUser(user);
		}
	}
	
}
