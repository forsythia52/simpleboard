package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.board.dto.BoardDto;

@Mapper
public interface BoardDao {

	@Select("select * from board")
	List<BoardDto> boardList();

	@Select("select * from board where boardnumber = #{boardnumber}")
	BoardDto boardView(String boardnumber);

	@Insert("insert into board (boardtitle, boardviews, boardwritedate, boarddtail, userid) "
			+ "values (#{boardtitle}, #{boardviews}, #{boardwritedate}, #{boarddtail}, #{userid})")
	int writeBoard(BoardDto boarddto);

	@Update("update board set boardtitle = #{boardtitle}, boarddtail = #{boarddtail} "
			+ "where boardnumber = #{boardnumber} and userid = #{userid}")
	int updateBoard(Map<String, Object> boardUpdate);

	@Delete("delete from board where boardnumber = #{boardnumber}")
	int deleteBoard(String boardumber);
}
