package com.biz.dripbag.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Qualifier("NoticeServiceV1")
@Service
public class NoticeServiceV1 implements NoticeService 
{	
	private final List<NoticeVO> noticeList;
	
	
	@Override
	public List<NoticeVO> selectAll() 
	{
		List<NoticeVO> tempList = new ArrayList<NoticeVO>();
		for(int j = noticeList.size()-1; j >= 0; --j)
			tempList.add(noticeList.get(j));
	
		return tempList;
	}

	@Override
	public NoticeVO findById(Long id) 
	{		
		NoticeVO noticeVO = new NoticeVO();		
		for(int i=0; i < noticeList.size(); ++i)
		{
			if(noticeList.get(i).getSeq() == id)
			{
				noticeVO = noticeList.get(i);
				return noticeVO;
			}
		}
		return null;
	}

	@Override
	public int insert(NoticeVO vo) 
	{	
		NoticeVO noticeVO = vo;
		noticeVO.setSeq(noticeList.size() + 1);
		noticeList.add(noticeVO);
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
