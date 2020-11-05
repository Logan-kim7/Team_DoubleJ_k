package com.biz.dripbag.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.dripbag.service.SearchService;

@RequestMapping(value="/{any}/search")
@Controller
public class SearchController 
{
	@Qualifier("searchServiceV1")
	@Autowired
	private SearchService sService;
		
	@ResponseBody
	@RequestMapping(value={"", "/"}, method = RequestMethod.GET)
	public List<Map<String, String>> search(@RequestParam Map<String, String> map, HttpServletRequest req)
	{
		 System.out.println(map.get("flag"));
		List<Map<String, String>> lists = sService.search(map.get("table"), map.get("flag"), map.get("content"));
		
		if(lists == null || lists.size() == 0)
			return null;
		
		req.getSession().setAttribute("SearchList", lists);
		return lists;
	}
	
	@ResponseBody
	@RequestMapping(value={"/clear", "/clear/"}, method = RequestMethod.GET)
	public void clear(String path, String flag, HttpServletRequest req)
	{
		if(flag.equals("0"))
			req.getSession().removeAttribute("SearchList");
	}
}
