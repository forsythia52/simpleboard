package com.board.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String mainPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			System.out.println(username);
		} else {
			String username = principal.toString();
			System.out.println(username);
		}
		System.out.println(auth);
		return "main";
	}
}
