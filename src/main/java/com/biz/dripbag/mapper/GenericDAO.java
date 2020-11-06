package com.biz.dripbag.mapper;

import java.util.List;

public interface GenericDAO<VO, PK> 
{
	public List<VO> selectAll();
	public VO findById(PK id);
	public VO findById(String id);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
}
