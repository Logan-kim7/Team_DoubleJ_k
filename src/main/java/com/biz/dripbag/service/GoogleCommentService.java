package com.biz.dripbag.service;

import java.util.List;

import com.biz.dripbag.model.GoogleCommentVO;
import com.biz.dripbag.model.NewsCommentVO;

public interface GoogleCommentService extends GenericService<GoogleCommentVO, Long> {

	public List<GoogleCommentVO> selectTop();
	public List<NewsCommentVO> findBySelect(long PK);
	
	public List<GoogleCommentVO> selectForForm(Long seqJ);

	int hit(GoogleCommentVO gcVO);
}
