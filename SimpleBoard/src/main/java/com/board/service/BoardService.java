package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;

@Service
public class BoardService {

	@Autowired
	BoardDao dao;

	public List<BoardDto> boardList() {
		return dao.boardList();
	}
	
	public int writeBoard(BoardDto boarddto) {
		return dao.writeBoard(boarddto);
	}
	
	public BoardDto boardView(String boardnumber) {
		return dao.boardView(boardnumber);
	}
}
