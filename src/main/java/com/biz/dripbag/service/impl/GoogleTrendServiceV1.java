package com.biz.dripbag.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.biz.dripbag.mapper.GoogleDAO;
import com.biz.dripbag.model.GoogleRankingVO;
import com.biz.dripbag.service.GoogleTrendeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("GoogleServiceV1")
public class GoogleTrendServiceV1 implements GoogleTrendeService 
{

	private final GoogleDAO googleDAO;
	
	@Override
	public List<GoogleRankingVO> selectAll() 
	{
		return googleDAO.selectAll();
	}

	@Override
	public GoogleRankingVO findById(Long id) 
	{
		return googleDAO.findById(id);
	}

	@Override
	public int insert(GoogleRankingVO vo) 
	{
		int ret = googleDAO.insert(vo);
		return ret;
	}

	@Override
	public int update(GoogleRankingVO vo) 
	{
		int ret = googleDAO.update(vo);
		return ret;
	}

	@Override
	public int delete(Long id) 
	{
		int ret = googleDAO.delete(id);
		return ret;
	}
	
}
