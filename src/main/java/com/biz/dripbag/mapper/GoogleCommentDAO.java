package com.biz.dripbag.mapper;

import java.util.List;

import com.biz.dripbag.model.GoogleCommentVO;
import com.biz.dripbag.model.NewsCommentVO;

public interface GoogleCommentDAO extends GenericDAO<GoogleCommentVO, Long> {

	public List<GoogleCommentVO> selectTop();

	public List<NewsCommentVO> findBySelect(long PK);

	public List<GoogleCommentVO> selectForForm(Long seqJ);

	public int hit(GoogleCommentVO gcVO);
}
