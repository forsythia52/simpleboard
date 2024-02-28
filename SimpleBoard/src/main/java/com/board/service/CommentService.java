package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.dao.CommentDao;
import com.board.dto.CommentDto;

@Service
public class CommentService {

	@Autowired
	CommentDao dao;

	@Autowired
	BoardDao boardDao;

	public List<CommentDto> commentList(String boardnumber) {
		return dao.commentList(boardnumber);
	}
	
	public List<Integer> boardNumber() {
		return dao.boardNumber();
	}
	
	public int commentWrite(CommentDto dto) {
		return dao.commentWrite(dto);
	}
	
	public int commentDelete(String number, String userId) {
		return dao.commentDelete(number, userId);
	}
}
