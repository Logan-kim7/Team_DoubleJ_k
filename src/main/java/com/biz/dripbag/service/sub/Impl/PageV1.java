package com.biz.dripbag.service.sub.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.PageDAO;
import com.biz.dripbag.model.SearchVO;
import com.biz.dripbag.service.sub.PageService;
import com.biz.dripbag.service.sub.SearchService;

@Service("pageV1")
public class PageV1 implements PageService 
{
	@Autowired
	private PageDAO pDAO;
	
	@Autowired(required = false)
	private List<SearchVO> pageList;
	
	@Autowired
	@Qualifier("searchServiceV1")
	private SearchService searchService;
		
	private int curPage = 1;
	private int allSize = 0;
	
	@Override
	public List<SearchVO> test(String table, String seq, String max, String flag, String page) 
	{
		long lseq = Long.valueOf(seq);
		curPage = Integer.valueOf(page);
		if(curPage == 1)
		{
			pageList = null;
			return null;
		}
	
		pageList = pDAO.test(table, lseq, max, flag, searchService.searchName());
		return pageList;
	}
	
	@Override
	public List<SearchVO> testj(String table, String seq, String max, String flag, String page) 
	{
		long lseq = Long.valueOf(seq);
		curPage = Integer.valueOf(page);
		if(curPage == 1)
		{
			pageList = null;
			return null;
		}
	
		pageList = pDAO.testj(table, lseq, max, flag, searchService.searchName());
		return pageList;
	}

	@Override
	public void clear() 
	{
		if(pageList != null)
		{
			pageList = null;
			curPage = 1;
		}
	}

	public List<SearchVO> getPage()
	{
		if(pageList != null)
			return pageList;

		else
			return null;

	}

	@Override
	public int curPage() {
		return curPage;
	}	
	
	public int allSize(String table)
	{
		return allSize = pDAO.size(table, searchService.searchName());
	}
	
	public int allSize(String table, long seqJ)
	{
		return allSize = pDAO.sizej(table, seqJ, searchService.searchName());
	}


}
