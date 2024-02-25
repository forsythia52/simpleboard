package com.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDto {
	
	private int boardnumber;
	private String commentuserid;
	private String commentcontent;
	private Date commentdate;
}
