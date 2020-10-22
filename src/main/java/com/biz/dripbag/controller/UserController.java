package com.biz.dripbag.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.SessionService;
import com.biz.dripbag.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = {"/user", "/user/"})
@Controller
public class UserController 
{	
	@Autowired
	@Qualifier("UserServiceV2")
	private UserService uService;
	
	@Autowired
	final SessionService sService;
	
	
	@ResponseBody
	@RequestMapping(value ="/master", method=RequestMethod.GET)
	public boolean master(HttpServletRequest req)
	{
		sService.tempMaster(req);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value ="/check/{id}", method=RequestMethod.GET)
	public String check(@PathVariable("id") String id)
	{
		return "aa";
	}
	@RequestMapping(value ={"/check", "/check/"}, method=RequestMethod.POST)
	public String check(UserVO userVO, Model model, HttpServletRequest req, HttpServletResponse res) throws IOException
	{
//		if(uService.checkByUser(userVO, 2) == 2)
//			sService.sessionRegistration(req, userVO);
//		
//		else
//			sService.interceptorLogin(res, "로그인또는 비밀번호 일치 하지 않음");
		
		return "redirect:/main/";
	}
	

	
	@RequestMapping(value= {"/join", "/join/"}, method = RequestMethod.POST)
	public void PostJoin(UserVO userVO, Model model)
	{				
		System.out.println(userVO.toString());
		if(uService.checkByUser(userVO, 1) == 1)
			uService.insert(userVO);
	}
	
	
	@RequestMapping(value= {"/logout", "/logout/"}, method = RequestMethod.GET)
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		sService.sessionRegistration(req, null);
		sService.interceptorLogin(res, "로그아웃 성공");
	}
	
}
