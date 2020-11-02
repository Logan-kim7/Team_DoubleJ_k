package com.biz.dripbag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.SearchDAO;
import com.biz.dripbag.service.SearchService;

@Service("searchServiceV1")
public class SearchServiceV1 implements SearchService
{
	@Autowired
	private SearchDAO searchDAO;

	@Override
	public String[] seachColumn(String table) 
	{
		/*
		 * String[] key = searchDAO.selectColumn("tbl_user").get(0).keySet().toArray(new
		 * String[searchDAO.selectColumn("tbl_user").size()]); for(String a : key)
		 * System.out.println(a);
		 * 
		 * searchDAO.searchListMap(key);
		 */
		
		return null;
	}
		
	/*
	 * public List<Map<String, String>> selectSearch(String table, String strFlag,
	 * String strSearchValue) 
	 * {
	 *  int index = 0; int flag = 0; 
	 *  List<Map<String, String>> searchList = searchDAO.selectAll(table);
	 * 
	 * String[] key = searchList.get(0).keySet().toArray(new String[searchList.size()]); 
	 * String q = null;
	 * if(searchList.get(0).get("D_SEQ") instanceof String == false) 
	 * q = String.valueOf(searchList.get(0).get("D_SEQ"));
	 * 
	 * System.out.println(q);
	 * 
	 * if(strFlag.equalsIgnoreCase("all")) flag = 1;
	 * 
	 * else if(strFlag.equalsIgnoreCase("content")) flag = 2;
	 * 
	 * else if(strFlag.equalsIgnoreCase("writer")) flag = 3;
	 * 
	 * switch (flag) {
	 * 
	 * case 1: // String[] key = searchList.get(0).keySet().toArray(new
	 * String[searchList.size()]); for(Map<String, String> i : searchList) { boolean
	 * ischeck = false; for(String j : key) {
	 * if(i.get(j).equalsIgnoreCase(strSearchValue) == true) ischeck = true; }
	 * if(ischeck == false) searchList.remove(index++); } break;
	 * 
	 * case 2: for(Map<String, String> one : searchList)
	 * if(one.get("content").equalsIgnoreCase(strSearchValue) == false)
	 * searchList.remove(index++); break;
	 * 
	 * case 3: for(Map<String, String> one : searchList)
	 * if(one.get("content").equalsIgnoreCase(strSearchValue) == false)
	 * searchList.remove(index++); break; }
	 * 
	 * return searchList; }
	 */
}


