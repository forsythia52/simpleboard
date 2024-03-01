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
	BoardDto boardView(String boardNumber);
	
	@Select("select count(*) from board")
	int boardCount();
	
	// 페이징
	@Select("select * from board order by boardnumber desc limit #{start}, #{count}")
	List<BoardDto> selectList(Map<String, Object> m);

	@Insert("insert into board (boardtitle, boardviews, boardwritedate, boarddtail, userid) "
			+ "values (#{boardtitle}, #{boardviews}, #{boardwritedate}, #{boarddtail}, #{userid})")
	int writeBoard(BoardDto boardDto);

	@Update("update board set boardtitle = #{boardtitle}, boarddtail = #{boarddtail} "
			+ "where boardnumber = #{boardnumber} and userid = #{userid}")
	int updateBoard(Map<String, Object> boardUpdate);
	
	@Update("update board set boardviews = boardviews + 1 where boardnumber = #{boardnumber}")
	int boardCountUp(String boardNumber);
	
	@Update("update board set commentcount = (select count(commentnumber) from comment where boardnumber = #{boardnumber})"
			+ "where boardnumber = #{boardnumber}")
	int commentCount(String boardNumber);
	
	@Delete("delete from board where boardnumber = #{boardnumber}")
	int deleteBoard(String boardNumber);
}
