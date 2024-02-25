package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.CommentDao;
import com.board.dto.CommentDto;

@Service
public class CommentService {

	@Autowired
	CommentDao dao;

	int commentList(CommentDto dto) {
		return dao.commentList(dto);
	}
}
