package com.biz.dripbag.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;
import com.biz.dripbag.service.SearchService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value="/notice")
@Controller
public class NoticeController
{
	@Qualifier("noticeServiceV1")
	private final NoticeService nService;
	
	@Qualifier("CrawlingData")
	private final CrwalingData cService;
			
	@RequestMapping(value={"/", ""}, method = RequestMethod.GET)
	public String home(Model model)
	{						
		
		model.addAttribute("GOOGLE", cService.getGoogleList());
		model.addAttribute("NEWS", 	cService.getNewsList());
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
		
	@RequestMapping(value="/detail/{notice_seq}")
	public String detail(@PathVariable("notice_seq") String seq, Model model)
	{

		model.addAttribute("BODY", "NOTICE_DETAIL");
		return "LJH/notice_home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model)
	{
		model.addAttribute("BODY", "NOTICE_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo)
	{
		return "LJH/notice_home";
	}
		
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public String selectList(Model model, @ModelAttribute("noticeVO") NoticeVO vo)
	{
		return "LJH/notice_home";
	}


	
}
