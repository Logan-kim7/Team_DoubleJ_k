package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;

@Qualifier("NoticeServiceV1")
@Service
public class NoticeServiceV1 implements NoticeService 
{
	
	@Override
	public List<NoticeVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
