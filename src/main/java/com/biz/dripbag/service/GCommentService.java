package com.biz.dripbag.service;

import java.util.List;

import com.biz.dripbag.model.GCommentVO;

public interface GCommentService extends GenericService<GCommentVO, Long>{
	
	public List<GCommentVO> selectTop();
}
