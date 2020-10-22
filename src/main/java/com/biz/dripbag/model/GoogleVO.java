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

	private long gtrand_seq;
	private String gtrand_date;
	private String gtrand_title;
	private String gtrand_img; 
}



