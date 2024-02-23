package com.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LoginDto {
	
	private String userId;
	private String userPassword;
	private Date userregisterdate;
	private String userrole;
	private String userName;
	private String userAddr1;
	private String userAddr2;
	private String userEmail;
	private String userPhone;
	private String userPhoto;
}
