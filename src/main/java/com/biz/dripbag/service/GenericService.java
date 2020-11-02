package com.biz.dripbag.service;

import java.util.List;

public interface GenericService<VO,PK>
{
	public List<VO> selectAll();
	public VO findById(PK id);
	public VO findById(String id);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
}
