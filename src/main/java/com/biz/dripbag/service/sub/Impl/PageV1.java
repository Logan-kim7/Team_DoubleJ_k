package com.biz.dripbag.service.sub.Impl;

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
	private List<SearchVO> list;
	
	@Autowired
	@Qualifier("searchServiceV1")
	private SearchService searchService;
	
	private boolean ischeck = false;
	private int curPage = 1;
	private int allSize = 0;
	
	@Override
	public List<SearchVO> test(String table, String seq, String max, String flag, String page) 
	{
		long lseq = Long.valueOf(seq);
		int pagecheck = curPage;
		curPage = Integer.valueOf(page);
		if(curPage == 1)
		{
			list = null;
			return null;
		}
	
		
		list = pDAO.test(table, lseq, max, flag, searchService.searchName());
		ischeck = true;
		return list;
	}

	@Override
	public void clear() 
	{
		if(list != null)
		{
			list = null;
			ischeck = false;
			curPage = 1;
		}
	}

	public List<SearchVO> getPage()
	{
		if(ischeck == true)
			return list;
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
