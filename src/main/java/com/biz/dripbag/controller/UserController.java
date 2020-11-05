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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = {"/user", "/user/"})
@Controller
public class UserController 
{	
	@Autowired
	@Qualifier("userServiceV2")
	private UserService uService;
	
	@Autowired
	@Qualifier("sessionServiceV1")
	private SessionService sService;
	
	@RequestMapping(value= {"/join", "/join/"}, method = RequestMethod.POST)
	public void Join(UserVO userVO, HttpServletResponse res) throws IOException
	{				
		if(uService.findById(0, userVO, null) != null)
			uService.insert(userVO);
		
		sService.locationJump(res, null, "회원가입 완료");
	}
	
	@ResponseBody
	@RequestMapping(value ={"/check/", "/check"}, method=RequestMethod.GET)
	public boolean joinIdCheck(@RequestParam("id") String id, String master)
	{	
		if(uService.findById(1, null, id) != null)
		{
			System.out.println("dd");
			return true;
		}
		
		return false;
	}
	
	@RequestMapping(value ={"/check", "/check/"}, method=RequestMethod.POST)
	public String check(UserVO userVO, HttpServletRequest req, HttpServletResponse res, String master) throws IOException
	{
		
		if(master != null)
			sService.sessionRegistration(req, null, master);
		
		else 
		{
			userVO = uService.findById(2, userVO, null);
			if(userVO != null)
				sService.sessionRegistration(req, userVO, null);
			else
				sService.locationJump(res, null, "ID or PWD 불일치");
		}

		
		
		return "redirect:/main/";
	}
	
	@RequestMapping(value= {"/logout", "/logout/"}, method = RequestMethod.GET)
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		sService.sessionRegistration(req, null, null);
		sService.locationJump(res, null, "로그아웃 성공");
	}
	
	
}
