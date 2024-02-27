package com.board.dto;

import lombok.Data;

@Data
public class BoardDto {
	
	private String boardnumber;
	private String userid;
	private String boardtitle;
	private int boardviews;
	private String boardwritedate;
	private String boarddtail;
}
