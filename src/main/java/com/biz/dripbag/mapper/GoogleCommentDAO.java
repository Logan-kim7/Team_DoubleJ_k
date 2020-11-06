package com.biz.dripbag.mapper;

import java.util.List;

import com.biz.dripbag.model.GoogleCommentVO;

public interface GoogleCommentDAO extends GenericDAO<GoogleCommentVO, Long> {

	public List<GoogleCommentVO> selectTop();

	public int hit(GoogleCommentVO gcVO);
}
