package com.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.board.dto.CommentDto;

@Mapper
public interface CommentDao {

	@Select("select * from comment where boardnumber = #{boardnumber}")
	List<CommentDto> commentList(String boardNumber);

	@Select("select boardnumber from board")
	List<Integer> boardNumber();
	
	@Insert("insert into comment(boardnumber, commentuserid, commentcontent, commentdate)"
			+ "values (#{boardnumber}, #{commentuserid}, #{commentcontent}, #{commentdate})")
	int commentWrite(CommentDto dto);
	
	@Delete("delete from comment where commentnumber = #{commentnumber} and commentuserid = #{commentuserid}")
	int commentDelete(@Param("commentnumber") String number, @Param("commentuserid") String userId);

}
