package com.biz.dripbag.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Qualifier("SessionServiceV1")
	final SessionService sService;
	
	@RequestMapping(value= {"/join", "/join/"}, method = RequestMethod.POST)
	public void Join(UserVO userVO, HttpServletResponse res) throws IOException
	{				
		if(uService.findById(0, userVO, null) == true)
			uService.insert(userVO);
		
		sService.locationJump(res, null, "회원가입 완료");
	}
	
	@ResponseBody
	@RequestMapping(value ={"/check/", "/check"}, method=RequestMethod.GET)
	public int check(@RequestParam("id") String id)
	{		
		if(uService.findById(1, null, id) == true)
			return 1;
		
		return 0;
	}
	
	@RequestMapping(value ={"/check", "/check/"}, method=RequestMethod.POST)
	public String check(UserVO userVO, HttpServletRequest req, HttpServletResponse res) throws IOException
	{

		if(uService.findById(2, userVO, null) == true)
			sService.sessionRegistration(req, userVO, null);

		else
			sService.locationJump(res, null, "ID or PWD 불일치");
		
		return "redirect:/main/";
	}
	
	@RequestMapping(value= {"/logout", "/logout/"}, method = RequestMethod.GET)
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		sService.sessionRegistration(req, null, null);
		sService.locationJump(res, null, "로그아웃 성공");
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/master", method=RequestMethod.GET)
	public void master(HttpServletRequest req, @RequestParam("master") String master)
	{
		sService.sessionRegistration(req, null, master);
	}
}
