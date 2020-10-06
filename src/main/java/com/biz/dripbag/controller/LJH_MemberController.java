package com.biz.dripbag.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/user")
@Controller
public class LJH_MemberController 
{	
	private final UserService userService;
	
	@RequestMapping(value ="/check", method=RequestMethod.POST)
	public String check(@ModelAttribute("userVO") UserVO userVO, Model model)
	{
		if(userService.check(userVO) == true)
		{
			return "redirect:/main/";
		}

		return "redirect:/";
	}
	
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joincheck(@ModelAttribute("userVO") UserVO userVO, Model model)
	{
		model.addAttribute("BODY", "INDEX_HOME");
		if(userService.joincheck(userVO) == false)
		{
			model.addAttribute("MSG", "중복된 아이디 입니다.");
			return "home";
		}
		else 
		{
			model.addAttribute("CREATE", "회원가입 완료");
			return "home";
		}		
	}
	
}
