package com.guruguruzom.boader.vo;

import java.util.Date;

import lombok.Data;

/*
 * 게시글 간편정보
 * */
@Data
public class BoaderSummary {
	private int itemSeq;
	private String title;
	private String writer;
	private Date updateAt;
}
