package com.biz.dripbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/main")
@Controller
public class MainController {
	
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String home() {
		return"home";
	}
		
		
	

}
