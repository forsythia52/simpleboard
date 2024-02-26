package com.board.service;

import java.util.List;
import java.util.Map;

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

	public int commentWrite(Map<String, Object> comment) {
		return dao.commentWrite(comment);
	}
}
