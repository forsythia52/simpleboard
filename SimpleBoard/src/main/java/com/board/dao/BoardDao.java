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

	// 제목 + 내용 검색
	@Select("select * from board where boardtitle like concat('%',#{boardtitle},'%') or boarddtail like concat('%',#{boarddtail},'%')")
	List<BoardDto> searchTitleAndDetail(Map<String, Object> search);

	// 작성자 검색
	@Select("select * from board where userid like concat('%',#{userid},'%')")
	List<BoardDto> searchWriter(Map<String, Object> search);

	// 페이징
	@Select("select * from board order by boardnumber desc limit #{start}, #{count}")
	List<BoardDto> selectList(Map<String, Object> m);

	@Insert("insert into board (userid, boardtitle, boardwritedate, boarddtail, filename, filepath) "
			+ "values (#{userid}, #{boardtitle}, #{boardwritedate}, #{boarddtail}, #{filename}, #{filepath})")
	int writeBoard(BoardDto boardDto);

	// 파일 다운로드
	@Select("select filename, filepath from board where boardnumber = #{boardnumber}")
	BoardDto fileDownload(String boardNumber);

	@Update("update board set boardtitle = #{boardtitle}, boarddtail = #{boarddtail} "
			+ "where boardnumber = #{boardnumber} and userid = #{userid}")
	int updateBoard(Map<String, Object> boardUpdate);

	@Update("update board set boardviews = boardviews + 1 where boardnumber = #{boardnumber}")
	int boardCountUp(String boardNumber);

	@Update("update board set commentcount = (select count(commentnumber) from comment where boardnumber = #{boardnumber})"
			+ "where boardnumber = #{boardnumber}")
	int commentCount(String boardNumber);

	@Delete("delete from board where boardnumber = #{boardnumber} and userid = #{userid}")
	int deleteBoard(Map<String, Object> boardInfo);
}
