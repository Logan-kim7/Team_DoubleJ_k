package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;

@Service("noticeServiceV1")
public class NoticeServiceV1 implements NoticeService 
{	

	@Override
	public List<NoticeVO> selectAll() 
	{
		return null;
	}

	@Override
	public NoticeVO findById(Long id) 
	{		
		return null;
	}

	@Override
	public int insert(NoticeVO vo) 
	{	
		return 0;
	}

	@Override
	public int update(NoticeVO vo) 
	{
		return 0;
	}

	@Override
	public int delete(Long id) 
	{
		return 0;
	}

	@Override
	public NoticeVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
