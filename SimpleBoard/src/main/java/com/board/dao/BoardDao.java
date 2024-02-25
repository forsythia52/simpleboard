package com.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.board.dto.BoardDto;

@Mapper
public interface BoardDao {

	@Select("select * from board")
	List<BoardDto> boardList();

	@Select("select * from board where boardnumber = #{boardnumber}")
	BoardDto boardView(String boardnumber);

	@Insert("insert into board (boardtitle, boardviews, boardwritedate, boarddtail) "
			+ "values (#{boardtitle}, #{boardviews}, #{boardwritedate}, #{boarddtail})")
	int writeBoard(BoardDto boarddto);
}
