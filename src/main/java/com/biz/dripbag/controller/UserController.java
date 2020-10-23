package com.biz.dripbag.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Qualifier("SessionServiceV1")
	final SessionService sService;
	
	@RequestMapping(value= {"/join", "/join/"}, method = RequestMethod.POST)
	public void Join(UserVO userVO, Model model)
	{				
		if(uService.checkByUser(userVO, 1) == true)
			uService.insert(userVO);
	}
	
	@ResponseBody
	@RequestMapping(value ="/master", method=RequestMethod.GET)
	public boolean master(HttpServletRequest req)
	{
		sService.master(req);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value ="/check/{id}", method=RequestMethod.GET)
	public boolean check(@PathVariable("id") String id)
	{
		if( uService.checkByUser(id) == true)
			return true;
		
		return false;
	}
	
	@RequestMapping(value ={"/check", "/check/"}, method=RequestMethod.POST)
	public String check(UserVO userVO, HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		if(uService.checkByUser(userVO, 2) == false)
			sService.sessionRegistration(req, userVO);

		else
			sService.locationJump(res, null, "ID or PWD 불일치");
		
		return "redirect:/main/";
	}
	
	@RequestMapping(value= {"/logout", "/logout/"}, method = RequestMethod.GET)
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		sService.sessionRegistration(req, null);
		sService.locationJump(res, null, "로그아웃 성공");
	}
	
}
