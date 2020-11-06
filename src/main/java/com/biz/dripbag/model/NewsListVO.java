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
public class NewsListVO 
{
	private long   seq;     //	NUMBER		PRIMARY KEY
	private String dates;    //	VARCHAR2(10)	NOT NULL	
	private String title;   //	VARCHAR2(10)	NOT NULL	
	private String img; 	  // nVARCHAR2(1300)		
	private String cont; //	nVARCHAR2(1300)			
}
