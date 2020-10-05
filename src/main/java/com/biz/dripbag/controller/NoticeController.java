package com.biz.dripbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/notice")
@Controller
public class NoticeController
{
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("BODY", "NOTICE_HOME");
		return "home";
	}
	
}
