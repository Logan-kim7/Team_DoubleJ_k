package com.biz.dripbag.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController 
{
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("BODY","INDEX_HOME");
		return "home";
	}
}
