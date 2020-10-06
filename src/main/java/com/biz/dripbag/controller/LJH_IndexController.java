package com.biz.dripbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.model.UserVO;


@Controller
public class LJH_IndexController 
{	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) 
	{
		UserVO userVO = new UserVO();
		model.addAttribute("BODY","INDEX_HOME");
		model.addAttribute("userVO", userVO);
		return "home";
	}
	
}
