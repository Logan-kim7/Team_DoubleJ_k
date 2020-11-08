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
public class SearchVO 
{
	private long seq; 	   // NUMBER		 PRIMARY KEY
	private long seqj;     // NUMBER		 PRIMARY KEY
	private String roll;
	private String pwd;
	private String email;
	private String img;
	private String writer; // nVARCHAR2(100) NOT NULL	
	private String dates;  // VARCHAR2(10)	 NOT NULL	
	private String times;  // VARCHAR2(10)	 NOT NULL	
	private String title;  // VARCHAR2(10)	 NOT NULL	
	private String cont;   // nVARCHAR2(20)		
	private int  likes;	   // NUMBER		
	private long views;    // NUMBER	
}
