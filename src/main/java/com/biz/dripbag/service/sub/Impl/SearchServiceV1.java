package com.biz.dripbag.service.sub.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.SearchDAO;
import com.biz.dripbag.model.SearchVO;
import com.biz.dripbag.service.sub.SearchService;

@Service("searchServiceV1")
public class SearchServiceV1 implements SearchService 
{
	@Autowired
	protected SearchDAO sDAO;
	
	@Autowired(required = false)
	protected List<SearchVO> searchList;
	
	private String strSearch = null;
			
	@Override
	public List<Map<String, String>> search(String table, String flag, String keyword) 
	{
		int index = 0;
		List<Map<String, String>> search = null;
		if(flag.equalsIgnoreCase("all")) index = 1;
		else if(flag.equalsIgnoreCase("title")) index = 2;
		else if(flag.equalsIgnoreCase("content")) index = 3;	  
		else if(flag.equalsIgnoreCase("writer")) index = 4;
				 	 
		 switch (index) 
		{
			case 1:
				search = sDAO.selectAll(table, keyword);
				break;
		
			case 2:
				search = sDAO.selectTitle(table, keyword);
								
			case 3:
				search = sDAO.selectContent(table, keyword);
								
			case 4:
				search = sDAO.selectWriter(table, keyword);		
		}		 
		 if(searchList.size() == 0)
			 return null;
		 
		 List<String> keyList = new ArrayList<>(search.get(0).keySet());

			for(int i=0; i<search.size(); ++i)
				 for(String one : keyList)
					 search.get(i).put(one, String.valueOf(search.get(i).get(one)));
			
		return search;
	}

	@Override
	public List<SearchVO> searchV2(String table, String flag, String keyword, String seq) 
	{
		int index = 0;
		if(table == null)
			return null;
		
		System.out.println("SEARCH V2" + seq);
		strSearch = keyword;
		if(flag.equalsIgnoreCase("all")) 		  index = 1;
		else if(flag.equalsIgnoreCase("title"))   index = 2;
		else if(flag.equalsIgnoreCase("content")) index = 3;	  
		else if(flag.equalsIgnoreCase("writer"))  index = 4;
				 	 
		 switch (index) 
		{
			case 1:
				searchList = sDAO.all(table, keyword, seq);
				break;
		
			case 2:
				searchList = sDAO.title(table, keyword, seq);
				break;
								
			case 3:
				searchList = sDAO.content(table, keyword, seq);
				break;
								
			case 4:
				searchList = sDAO.writer(table, keyword, seq);
				break;
		}	
		 if(searchList.size() == 0 || searchList == null)
			 return null;

		return searchList;
	}

	@Override
	public void clear() 
	{
		if(searchList != null)
		{
			searchList = null;
			strSearch = null;
		}
	}

	@Override
	public List<SearchVO> getSearch() 
	{
		return this.searchList;
	}

	@Override
	public String searchName() {
		return strSearch;
	}

}
