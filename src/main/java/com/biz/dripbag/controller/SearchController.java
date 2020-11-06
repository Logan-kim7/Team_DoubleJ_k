package com.biz.dripbag.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
	public boolean search(@RequestParam Map<String, String> map, HttpServletRequest req)
	{		
		if(sService.searchV2(map.get("table"), map.get("flag"), map.get("content")) == null)
		{
			sService.clear();
			return false;
		}

		return true;
	}
}
