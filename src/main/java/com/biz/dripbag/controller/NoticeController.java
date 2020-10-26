package com.biz.dripbag.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.DateService;
import com.biz.dripbag.service.NoticeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value="/notice")
@Controller
public class NoticeController
{
	@Qualifier("NoticeServiceV1")
	private final NoticeService noticeService;
	private final DateService dService;
	
	@RequestMapping(value={"/", ""}, method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req)
	{			
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
		
	@RequestMapping(value="/detail/{notice_seq}")
	public String detail(@PathVariable("notice_seq") String seq, Model model)
	{

		model.addAttribute("BODY", "NOTICE_DETAIL");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo, String dummy)
	{
		model.addAttribute("BODY", "NOTICE_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model, @ModelAttribute("noticeVO") NoticeVO vo)
	{
		return "redirect:/noticeHome";
	}
	
}
