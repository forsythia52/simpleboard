package com.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDto {
	
	private String boardnumber;
	private String commentuserid;
	private String commentcontent;
	private Date commentdate;
}
