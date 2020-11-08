package com.biz.dripbag.mapper;


import java.util.List;

import com.biz.dripbag.model.NewsCommentVO;

public interface NewsCommentDAO extends GenericDAO<NewsCommentVO, Long> {
	public List<NewsCommentVO> findBySelect(long PK);
	public List<NewsCommentVO> selectTop();
}
