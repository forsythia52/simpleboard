package com.board.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.board.dto.LoginDto;

@Mapper
public interface LoginDao {
	@Select("select * from users where userid = #{id}")
	LoginDto findById(String userId);
	
	@Insert("insert into users(usernumber, userid, userpassword, userregisterdate, userrole, username, useraddr1, useraddr2, useremail, userphone, userphoto)"
			+ "values(#{usernumber}, #{userid}, #{userpassword}, #{userregisterdate}, #{userrole}, #{username}, #{useraddr1}, #{useraddr2}, #{useremail}, #{userphone}, #{userphoto})")
	int userRegister(Map<String, Object> user);
	
}
