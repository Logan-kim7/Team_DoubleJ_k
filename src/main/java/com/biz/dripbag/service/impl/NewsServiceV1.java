package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.NewsVO;
import com.biz.dripbag.service.NewsService;

@Service("newsServiceV1")
public class NewsServiceV1 implements NewsService 
{
	@Override
	public List<NewsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NewsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NewsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NewsVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
