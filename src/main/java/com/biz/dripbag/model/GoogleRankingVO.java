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
public class GoogleRankingVO {

	private long   gt_seq;   // NUMBER PRIMARY KEY
	private String gt_date;  // VARCHAR2(10)	  NOT NULL	
	private String gt_title; // nVARCHAR2(225) NOT NULL	
	private String gt_img;	 // nVARCHAR2(225)		

}



