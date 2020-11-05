package com.biz.dripbag.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NoticeVO 
{
	private long   seq;
	private String dates;
	private String times;
	private String title;
	private String writer;
	private String cont;
	private long likes;
	private long views;
	
}
