package com.board.service;

import java.util.List;
import java.util.Map;

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
	
	public BoardDto boardView(String boardnumber) {
		return dao.boardView(boardnumber);
	}
	
	public int writeBoard(BoardDto boarddto) {
		return dao.writeBoard(boarddto);
	}
	
	public int updateBoard(Map<String, Object> boardUpdate) {
		return dao.updateBoard(boardUpdate);
	}
	
	public int deleteBoard(String boardumber) {
		return dao.deleteBoard(boardumber);
	}
}
