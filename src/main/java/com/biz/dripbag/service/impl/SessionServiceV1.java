package com.biz.dripbag.service.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.SessionService;

import lombok.extern.slf4j.Slf4j;

@Component("SessionServiceV1")
@Slf4j
public class SessionServiceV1 implements SessionService
{
	
	@Override
	public void master(HttpServletRequest req) 
	{
		req.getSession().setAttribute("login_registration", "Master");
	}
	
	@Override
	public boolean sessionRegistration(HttpServletRequest req, UserVO vo) 
	{
		if(req.getSession().getAttribute("login_registration") != null)
		{
			req.getSession().removeAttribute("login_registration");
			log.debug("로그아웃 성공");
			return false;
		}
		
		req.getSession().setAttribute("login_registration", vo);
		return true;
	}
	
	@Override
	public void locationJump(HttpServletResponse response, String url, String msg) throws IOException 
	{	
		if(url == null)
			url = "";
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<script language='javascript'>");
		out.println("alert('" +  msg + "')");
		out.println("document.location.href='/dripbag/"+ url +"'");
		out.println("</script>");
		out.flush();
		out.close();		
	}




}
