package com.biz.dripbag.service;

import java.util.List;

import com.biz.dripbag.model.GoogleCommentVO;

public interface GoogleCommentService extends GenericService<GoogleCommentVO, Long> {

	public List<GoogleCommentVO> selectTop();

	int hit(GoogleCommentVO gcVO);
}
