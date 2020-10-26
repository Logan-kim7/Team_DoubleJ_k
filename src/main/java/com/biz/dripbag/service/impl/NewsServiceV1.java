package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.model.NewsRankingVO;
import com.biz.dripbag.service.NewsService;

@Service("NewsServiceV1")
public class NewsServiceV1 implements NewsService 
{
	@Override
	public List<NewsRankingVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsRankingVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NewsRankingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NewsRankingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NewsRankingVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
