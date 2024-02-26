package com.board.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.config.SecurityUser;
import com.board.dto.CommentDto;
import com.board.dto.LoginDto;
import com.board.service.BoardService;
import com.board.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	CommentService service;

	@Autowired
	BoardService boardService;

	@PostMapping("/comment/write")
	public String commentWrite(CommentDto dto, @AuthenticationPrincipal SecurityUser user,
			@RequestParam(value = "boardnumber") String boardNumber) {
		LoginDto userInfo = user.getUsers();
		String userId = userInfo.getUserId();
//		System.out.println(boardNumber);
		dto.setCommentuserid(userId);
		System.out.println("채팅" + dto);
		return "redirect:/freeboard";
	}

//	@PostMapping("/comment/write")
//	public String commentWrite(@RequestParam(value = "commentcontent") String commentContent,
//			@AuthenticationPrincipal SecurityUser user) {
//		String boardNumber = service.boardNumber();
//		System.out.println(boardNumber);
//		Map<String, Object> comment = new HashMap<>();
//		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		System.out.println(now.format(format));
//		LoginDto dto = user.getUsers();
//		String userId = dto.getUserId();
//		comment.put("boardnumber", 6);
//		comment.put("commentcontent", commentContent);
//		comment.put("commentuserid", userId);
//		comment.put("commentdate", now);
//		service.commentWrite(comment);
//		System.out.println(comment);
//		return "redirect:/freeboard";
//	}

}
