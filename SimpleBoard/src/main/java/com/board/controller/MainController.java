package com.board.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String mainPage(Model m) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// id 추출
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			System.out.println("UserDetails: " + username);
			m.addAttribute("id", username);
		} 
		
		System.out.println("auth: " + auth);

		return "main";
	}
}
