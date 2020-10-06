package com.biz.dripbag.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.model.NoticeVO;
import com.biz.dripbag.service.NoticeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value="/notice")
@Controller
public class LJH_NoticeController
{
	@Qualifier("NoticeServiceV1")
	private final NoticeService noticeService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req)
	{			
		
		List<NoticeVO> lists =  noticeService.selectAll();
		
		for(NoticeVO vo : lists)
			System.out.println(vo.toString());
		
		model.addAttribute("NOTICE", noticeService.selectAll());
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
	
	
	@RequestMapping(value="/detail/{notice_seq}")
	public String detail(@PathVariable("notice_seq") String seq, Model model)
	{
		System.out.println(seq);
		return null;
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
		NoticeVO noticeVO = vo;
		noticeService.insert(noticeVO);
		System.out.println(noticeService.selectAll().toString());
		model.addAttribute("BODY", "NOTICE_WRITE");
		return "home";
	}
	
}
