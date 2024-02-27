package com.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.board.config.SecurityUser;
import com.board.dto.LoginDto;

@Controller
public class MainController {

	@GetMapping("/main")
	public String main(@AuthenticationPrincipal SecurityUser user, Model m) {
		LoginDto userinfo = user.getUsers();
		String nickname = userinfo.getUsernickname();
		m.addAttribute("nickname", nickname);
		return "main";
	}
}
