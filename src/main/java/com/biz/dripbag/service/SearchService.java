package com.biz.dripbag.service;

import java.util.List;
import java.util.Map;

import com.biz.dripbag.model.SearchVO;

public interface SearchService 
{
	public List<Map<String, String>> search(String table, String flag, String keyword);
	public List<SearchVO> searchV2(String table, String flag, String keyword);
	public void clear();
	public  List<SearchVO> getSearch();
}
