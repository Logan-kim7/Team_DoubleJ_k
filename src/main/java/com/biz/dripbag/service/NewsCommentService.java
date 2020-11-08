package com.biz.dripbag.service;

import java.util.List;

import com.biz.dripbag.model.NewsCommentVO;

public interface NewsCommentService extends GenericService<NewsCommentVO, Long> {

	public List<NewsCommentVO> findBySelect(long PK);
	
	public List<NewsCommentVO> selectTop();
	
	
	

}
