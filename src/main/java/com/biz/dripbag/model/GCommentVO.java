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
public class GCommentVO {
	private Long gc_seq;
	private Long gc_seqC;
	private String gc_writer;
	private String gc_date;
	private String gc_time;
	private String gc_title;
	private String gc_explain;
	private Long gc_likes;
	private Long gc_views;
}
