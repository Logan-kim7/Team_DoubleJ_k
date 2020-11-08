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
	private long seq; 	   // NUMBER		PRIMARY KEY
	private String email;    // nVARCHAR2(100)	UNIQUE NOT NULL	
	private String pwd; // nVARCHAR2(30)	NOT NULL	
	private int    roll;	   	   // NUMBER	NOT NULL	
	private String dates;	   // VARCHAR2(10)	NOT NULL	

}
