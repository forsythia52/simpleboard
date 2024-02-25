package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@PostMapping("/comment/write")
	public String commentWrite(@PathVariable int number) {
		System.out.println(number +  "번 게시판 댓글 작성");
		return "redirect:/view?number=" + number;
	}
	
	
}
