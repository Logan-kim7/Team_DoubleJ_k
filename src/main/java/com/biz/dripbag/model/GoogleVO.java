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
public class GoogleVO {

	String title;
	String approxTraffic;
	String googleDate;
	String imgPath; 
}
