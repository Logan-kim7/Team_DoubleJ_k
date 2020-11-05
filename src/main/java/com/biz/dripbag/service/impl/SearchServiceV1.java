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
		
		List<Map<String, String>> searchList = null;
		int index = 0;
		
		if(flag.equalsIgnoreCase("all")) index = 1;
		else if(flag.equalsIgnoreCase("title")) index = 2;
		else if(flag.equalsIgnoreCase("content")) index = 3;	  
		else if(flag.equalsIgnoreCase("writer")) index = 4;
				 	 
		 switch (index) 
		{
			case 1:
				searchList = sDAO.selectAll(table, keyword);
				break;
		
			case 2:
				searchList = sDAO.selectTitle(table, keyword);
								
			case 3:
				searchList = sDAO.selectContent(table, keyword);
								
			case 4:
				searchList = sDAO.selectWriter(table, keyword);		
		}		 
		 if(searchList.size() == 0)
			 return null;
		 
		 List<String> keyList = new ArrayList<>(searchList.get(0).keySet());
		 System.out.println(keyList.size());

			for(int i=0; i<searchList.size(); ++i)
				 for(String one : keyList)
					 searchList.get(i).put(one, String.valueOf(searchList.get(i).get(one)));
			
		return searchList;
	}
}
