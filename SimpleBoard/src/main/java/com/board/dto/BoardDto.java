package com.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	
	private int boardnumber;
	private String userid;
	private String boardtitle;
	private String boardviews;
	private Date boardwritedate;
	private String boarddtail;
}
