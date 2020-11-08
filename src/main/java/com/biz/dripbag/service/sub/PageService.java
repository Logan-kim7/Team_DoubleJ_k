package com.biz.dripbag.service.sub;

import java.util.List;

import com.biz.dripbag.model.SearchVO;

public interface PageService 
{
	public List<SearchVO> test(String table, String seq, String max, String flag, String page);
	public List<SearchVO> testj(String table, String seq, String max, String flag, String page);
	public List<SearchVO> getPage();
	public int allSize(String table, long seqJ);
	public int allSize(String table);
	public int curPage();
	public void clear();
}
