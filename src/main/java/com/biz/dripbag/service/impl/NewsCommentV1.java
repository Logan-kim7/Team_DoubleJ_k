package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.NewsCommentDAO;
import com.biz.dripbag.model.NewsCommentVO;
import com.biz.dripbag.service.NewsCommentService;
import com.biz.dripbag.service.sub.DateService;

@Service("NewsCommentV1")
public class NewsCommentV1 implements NewsCommentService 
{
	@Autowired
	private NewsCommentDAO newsCommentDAO;
	
	@Autowired
	private DateService dateService;
	
	@Override
	public List<NewsCommentVO> selectAll() 
	{
		
		return newsCommentDAO.selectAll();
	}

	@Override
	public NewsCommentVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsCommentVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NewsCommentVO vo) 
	{
		vo.setDates(dateService.dateTime()[0]);
		vo.setTimes(dateService.dateTime()[1]);
		int ret = newsCommentDAO.insert(vo);
		return ret;
	}

	@Override
	public int update(NewsCommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
