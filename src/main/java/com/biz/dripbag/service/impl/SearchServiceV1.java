package com.biz.dripbag.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.SearchDAO;
import com.biz.dripbag.service.SearchService;

@Service("searchServiceV1")
public class SearchServiceV1 implements SearchService {
	@Autowired
	private SearchDAO sDAO;

	@Override
	public List<Map<String, String>> search(String table, String flag, String keyword) 
	{
		//List<String> keyList = new ArrayList<>(sDAO.selectColumn("tbl_user").keySet());		
		int index = 0;
		
		if(flag.equalsIgnoreCase("all")) index = 1;
		else if(flag.equalsIgnoreCase("title")) index = 2;
		else if(flag.equalsIgnoreCase("content")) index = 3;	  
		else if(flag.equalsIgnoreCase("writer")) index = 4;
				 	 
		 switch (index) 
		{
			case 1:
				return sDAO.selectAll(table, keyword);
		
			case 2:
				return sDAO.selectTitle(table, keyword);
								
			case 3:
				return sDAO.selectContent(table, keyword);
								
			case 4:
				return sDAO.selectWriter(table, keyword);		
		}
		 
		return null;
	}
}
