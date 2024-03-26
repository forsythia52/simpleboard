package com.board.controller;

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

	// 댓글 작성
	@PostMapping("/comment/write")
	public String commentWrite(CommentDto dto, @AuthenticationPrincipal SecurityUser user,
			@RequestParam(value = "commentcontent") String commentcontent,
			@RequestParam(value = "boardnumber") String boardNumber) {
		LoginDto userInfo = user.getUsers();
		String userId = userInfo.getUserId();
		Date now = new Date();
		dto.setBoardnumber(boardNumber);
		dto.setCommentuserid(userId);
		dto.setCommentdate(now);
		dto.setCommentcontent(commentcontent);
//		service.commentWrite(dto);
		System.out.println(dto);
//		boardService.commentCount(boardNumber);
		return "redirect:/freeboard";
	}

	// 댓글 삭제
	@PostMapping("/comment/delete")
	public String commentDelete(@RequestParam(value = "commentuserid") String userId,
			@RequestParam(value = "commentnumber") String number,
			@RequestParam(value = "boardnumber") String boardNumber) {
		service.commentDelete(number, userId);
		boardService.commentCount(boardNumber);
		return "redirect:/freeboard";
	}

}
