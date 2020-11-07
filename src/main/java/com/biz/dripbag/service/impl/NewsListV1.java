package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.NewsListDAO;
import com.biz.dripbag.model.NewsListVO;
import com.biz.dripbag.service.NewsListService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service("newsServiceV1")
public class NewsListV1 implements NewsListService 
{
	@Autowired
	private NewsListDAO newsListDAO;
	
	@Override
	public List<NewsListVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsListVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NewsListVO vo) 
	{
		newsListDAO.insert(vo);
		int ret = (int)vo.getSeq();
		return ret;
	}

	@Override
	public int update(NewsListVO vo) {
		

		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NewsListVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
