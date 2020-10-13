package com.biz.dripbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/news")
@Controller
public class NewsController {
	
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String news(Model model) {
		model.addAttribute("BODY","NEWS_HOME");
		
		return "home";
	}

}
