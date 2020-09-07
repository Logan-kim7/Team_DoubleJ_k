package com.biz.dripbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/info")
@Controller
public class InfoController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String info(Model model) {
		
		model.addAttribute("BODY","INFO_HOME");
		return "home";
	}

}
