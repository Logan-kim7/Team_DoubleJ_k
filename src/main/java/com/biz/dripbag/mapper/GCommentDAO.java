package com.biz.dripbag.mapper;

import java.util.List;

import com.biz.dripbag.model.GCommentVO;

public interface GCommentDAO extends GenericDAO<GCommentVO, Long> {

	public List<GCommentVO> selectTop();

	public int hit(GCommentVO gcVO);
}
