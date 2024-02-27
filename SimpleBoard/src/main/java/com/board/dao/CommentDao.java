package com.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.board.dto.CommentDto;

@Mapper
public interface CommentDao {

	@Select("select * from comment where boardnumber = #{boardnumber}")
	List<CommentDto> commentList(String boardnumber);

	@Insert("insert into comment(boardnumber, commentuserid, commentcontent, commentdate)"
			+ "values (#{boardnumber}, #{commentuserid}, #{commentcontent}, #{commentdate})")
	int commentWrite(CommentDto dto);

}
