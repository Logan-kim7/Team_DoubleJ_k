package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.GoogleListDAO;
import com.biz.dripbag.model.GoogleListVO;
import com.biz.dripbag.service.GoogleListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("googleServiceV1")
public class GoogleListServiceV1 implements GoogleListService 
{

	private final GoogleListDAO googleDAO;
	
	@Override
	public List<GoogleListVO> selectAll() 
	{
		return googleDAO.selectAll();
	}

	@Override
	public GoogleListVO findById(Long id) 
	{
		return googleDAO.findById(id);
	}
	
	@Override
	public int insert(GoogleListVO vo) 
	{
		googleDAO.insert(vo);
		int ret = (int)vo.getSeq();
		return ret;
	}

	@Override
	public int update(GoogleListVO vo) 
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

	@Override
	public GoogleListVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
