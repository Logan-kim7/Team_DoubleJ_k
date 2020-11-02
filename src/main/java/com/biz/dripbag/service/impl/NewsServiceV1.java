package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.NewsDAO;
import com.biz.dripbag.model.NewsVO;
import com.biz.dripbag.service.NewsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("NewsServiceV1")
public class NewsServiceV1 implements NewsService {

	private final NewsDAO newsDAO;

	@Override
	public List<NewsVO> selectAll() {

		return newsDAO.selectAll();
	}

	@Override
	public NewsVO findById(Long id) {

		return newsDAO.findById(id);
	}

	@Override
	public int insert(NewsVO vo) {
		int ret = newsDAO.insert(vo);

		return ret;
	}

	@Override
	public int update(NewsVO vo) {

		int ret = newsDAO.update(vo);
		return ret;
	}

	@Override
	public int delete(Long id) {
		int ret = newsDAO.delete(id);

		return ret;
	}

}
