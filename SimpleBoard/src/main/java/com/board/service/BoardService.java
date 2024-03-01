package com.board.service;

import java.util.HashMap;
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

	public int boardCount() {
		return dao.boardCount();
	}

	// 페이징
	public List<BoardDto> selectList(int start) {
		Map<String, Object> m = new HashMap<>();
		m.put("start", start);
		m.put("count", 10);
		return dao.selectList(m);
	}

	public int writeBoard(BoardDto boardDto) {
		return dao.writeBoard(boardDto);
	}

	public int updateBoard(Map<String, Object> boardUpdate) {
		return dao.updateBoard(boardUpdate);
	}

	public int boardCountUp(String boardNumber) {
		return dao.boardCountUp(boardNumber);
	}

	public int commentCount(String boardNumber) {
		return dao.commentCount(boardNumber);
	}

	public int deleteBoard(String boardNumber) {
		return dao.deleteBoard(boardNumber);
	}
}
