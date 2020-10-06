package com.biz.dripbag.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.service.NoticeService;


@RequestMapping(value="/notice")
@Controller
public class LJH_NoticeController
{
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req)
	{
		model.addAttribute("NOTICE", "TEST");
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
}
