package com.board.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.board.dto.CommentDto;

@Mapper
public interface CommentDao {

	@Insert("insert into (boardnumber, commentuserid, commentcontent, commentdate)"
			+ "values (#{boardnumber}, #{commentuserid}, #{commentcontent}, #{commentdate})")
	int commentList(CommentDto dto);

}
