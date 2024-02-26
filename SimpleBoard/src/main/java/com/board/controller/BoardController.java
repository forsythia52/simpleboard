package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.config.SecurityUser;
import com.board.dto.BoardDto;
import com.board.dto.LoginDto;
import com.board.service.BoardService;
import com.board.service.CommentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/freeboard")
	public String freeBoard(Model m) {
		m.addAttribute("board", service.boardList());
		return "board/freeboard";
	}

	@GetMapping("/boardwrite")
	public String boardWrite(@AuthenticationPrincipal SecurityUser user, Model m) {
		LoginDto userinfo = user.getUsers();
		String id = userinfo.getUserId();
		System.out.println("boardwrite " + id);
		m.addAttribute("id", id);
		return "board/boardwrite";
	}

	@GetMapping("/view")
	public String view(HttpServletRequest request, Model m) {
		String boardnumber = request.getParameter("number");
		System.out.println(boardnumber);
		m.addAttribute("board", service.boardView(boardnumber));
		m.addAttribute("comment",commentService.commentList(boardnumber));
		return "board/freeboardview";
	}

	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto dto, Model m) {
		service.writeBoard(dto);
		return "redirect:freeboard";
	}

	@DeleteMapping("/delete")
	public String delete(HttpServletRequest request, Model m) {
//		dao.deleteDao(request.getParameter("id"));
		return "redirect:freeboard";
	}
}
