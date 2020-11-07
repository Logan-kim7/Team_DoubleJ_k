package com.biz.dripbag.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoogleCommentVO {
	private Long seq;
	private Long seqj;
	private String writer;
	private String dates;
	private String times;
	private String title;
	private String cont;
	private Long likes;
	private Long views;
}
