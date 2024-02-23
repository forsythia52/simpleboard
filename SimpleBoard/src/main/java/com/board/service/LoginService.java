package com.board.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	LoginDao dao;

	public int userRegister(Map<String, Object> user) {
		return dao.userRegister(user);
	}
	
}
