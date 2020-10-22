package com.biz.dripbag.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserVO 
{
	private String d_seq; 	   // NUMBER		PRIMARY KEY
	private String d_email;    // nVARCHAR2(100)	UNIQUE NOT NULL	
	private String d_password; // nVARCHAR2(30)	NOT NULL	
	private int    d_roll;	   	   // NUMBER	NOT NULL	
	private String d_date;	   // VARCHAR2(10)	NOT NULL	

}
