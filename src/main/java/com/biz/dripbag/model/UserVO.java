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
	private String u_seq; 	   // NUMBER		PRIMARY KEY
	private String u_email;    // nVARCHAR2(100)	UNIQUE NOT NULL	
	private String u_password; // nVARCHAR2(30)	NOT NULL	
	private int u_roll;	   	   // NUMBER	NOT NULL	
	private String u_date;	   // VARCHAR2(10)	NOT NULL	

}
