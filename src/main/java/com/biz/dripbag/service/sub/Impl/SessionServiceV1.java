package com.biz.dripbag.service.sub.Impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.sub.PageService;
import com.biz.dripbag.service.sub.SearchService;
import com.biz.dripbag.service.sub.SessionService;


@Service("sessionServiceV1")
public class SessionServiceV1 implements SessionService
{	
	@Qualifier("searchServiceV1")
	@Autowired
	SearchService search;
	
	@Qualifier("pageV1")
	@Autowired
	PageService page;
	
	private String urlPath;
	
	@Override
	public boolean sessionRegistration(HttpServletRequest req, UserVO vo, String master) 
	{
		if(req.getSession().getAttribute("login_registration") != null)
		{
			req.getSession().removeAttribute("login_registration");
				return false;
		}
		
		if(master != null && master.equals("master"))
		{
			vo = new UserVO();
			vo.setEmail("master");
			vo.setRoll(1);
			req.getSession().setAttribute("member", vo);
			vo = null;
			return true;
		}
		
		req.getSession().setAttribute("member", vo);
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

	public void Searchclear(HttpServletRequest req)
	{
		String temp = splitStr(req.getServletPath());
		if(urlPath == null)
			urlPath = temp;

		if(temp.contains(urlPath) == false )
		{
			search.clear();
			page.clear();
			urlPath = temp;
		}
	}
	
	public void navFlag(HttpServletRequest req)
	{
		String temp = splitStr(req.getServletPath());
		int flag = 0;
		
		if(temp.contains("main")) flag = 0;
		else if(temp.contains("halloffame")) flag = 1;
		else if(temp.contains("info")) flag = 2;
		else if(temp.contains("notice")) flag = 3;
		req.getSession().setAttribute("navFlag", flag);
	}

	public String splitStr(String url)
	{
		url = url.substring(1);
		url = url.substring(0, url.indexOf("/"));
		return url;
	}
}
