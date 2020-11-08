package com.biz.dripbag.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.dripbag.service.sub.PageService;
import com.biz.dripbag.service.sub.SearchService;

@RequestMapping(value="/page")
@Controller
public class PageController 
{
	@Qualifier("pageV1")
	@Autowired
	private PageService pageService;
		
	@ResponseBody
	@RequestMapping(value= {"", "/"}, method = RequestMethod.GET)
	public boolean page(Model model, @RequestParam Map<String, String> map)
	{			
		System.out.println("ddddd");
		pageService.test("tbl_notice", map.get("seq"), map.get("max"), map.get("flag"), map.get("nextpage"));		
		return true;
	}
	
}
