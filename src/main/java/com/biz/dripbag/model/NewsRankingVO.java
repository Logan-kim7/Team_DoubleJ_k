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
public class NewsRankingVO 
{
	private long   n_seq;     //	NUMBER		PRIMARY KEY
	private String n_date;    //	VARCHAR2(10)	NOT NULL	
	private String n_title;   //	VARCHAR2(10)	NOT NULL	
	private String n_img; 	  // nVARCHAR2(1300)		
	private String n_content; //	nVARCHAR2(1300)			
}
