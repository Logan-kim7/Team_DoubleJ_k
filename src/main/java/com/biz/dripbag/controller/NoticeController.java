package com.biz.dripbag.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.crawling.CrwalingData;
import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.HitService;
import com.biz.dripbag.service.NoticeService;
import com.biz.dripbag.service.SearchService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value="/notice")
@Controller
public class NoticeController
{
	@Qualifier("noticeServiceV1")
	private final NoticeService noticeService;
	
	@Qualifier("CrawlingData")
	private final CrwalingData cService;
	
	@Qualifier("hitV1")
	private final HitService hService;
	
	@Qualifier("searchServiceV1")
	private final SearchService searchService;
					
				
	@RequestMapping(value={"/", ""}, method = RequestMethod.GET)
	public String home(Model model)
	{		
		if(searchService.getSearch() != null)
			model.addAttribute("LIST", searchService.getSearch());
		
		else
			model.addAttribute("LIST", noticeService.selectAll());

		
		model.addAttribute("GOOGLE", cService.getGoogleList());
		model.addAttribute("NEWS", 	cService.getNewsList());
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
		
	@RequestMapping(value="/detail/{seq}")
	public String detail(@PathVariable("seq") String seq, Model model, HttpServletRequest req)
	{
		long iseq = Long.valueOf(seq);
		noticeService.hit(iseq);
				
		model.addAttribute("BODY", "NOTICE_DETAIL");
		return "home";
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
		noticeService.insert(vo);
		return "redirect:/notice/";
	}
		
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public String selectList(Model model, @ModelAttribute("noticeVO") NoticeVO vo)
	{
		return "LJH/notice_home";
	}


	
}
