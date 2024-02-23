package com.board.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	public String Login() {
		return "login/login";
	}
		
	@GetMapping("/register")
	public String Regisetr() {
		return "login/register";
	}

	@PostMapping("/register")
	public String userRegister(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw,
			@RequestParam(value = "name") String name, @RequestParam(value = "userAddr1") String addr1,
			@RequestParam(value = "userAddr2") String addr2, @RequestParam(value = "email") String email,
			@RequestParam(value = "phone") String phone) {
		Map<String, Object> user = new HashMap<>();
		LocalDate now = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.put("userid", id);
		user.put("userpassword", encoder.encode(pw));
		user.put("username", name);
		user.put("userregisterdate", now.format(format));
		user.put("userrole", "ROLE_MEMBER");
		user.put("useraddr1", addr1);
		user.put("useraddr2", addr2);
		user.put("useremail", email);
		user.put("userphone", phone);
		service.userRegister(user);
		System.out.println("회원가입 완료");
		return "login/registercomplete";
	}

}
