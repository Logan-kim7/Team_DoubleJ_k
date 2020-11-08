package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.NoticeDAO;
import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;
import com.biz.dripbag.service.sub.DateService;

@Service("noticeServiceV1")
public class NoticeServiceV1 implements NoticeService 
{	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private DateService dateService;
	
	@Override
	public List<NoticeVO> selectAll() 
	{
		return noticeDAO.selectAll();
	}

	@Override
	public NoticeVO findById(Long id) 
	{		
		return null;
	}

	@Override
	public int insert(NoticeVO vo) 
	{	
		vo.setDates(dateService.dateTime()[0]);
		vo.setTimes(dateService.dateTime()[1]);
		int ret = noticeDAO.insert(vo);
		return ret;
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

	@Override
	public boolean hit(long pk) 
	{
		long hit = noticeDAO.hit(pk);
		return false;
	}

	@Override
	public int deletes(String[] pk)
	{	
		return noticeDAO.deletes(pk);	
	}
}
