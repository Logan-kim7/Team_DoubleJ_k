package com.biz.dripbag.service.sub.Impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.service.sub.DateService;
import com.biz.dripbag.service.sub.HitService;

@Service("hitV1")
public class HitV1 implements HitService 
{
	
	@Override
	public boolean hit(HttpServletRequest req) 
	{
		if(req.getSession().getAttribute("hitTime") == null)
			return true;
		
		else
			return false;
	}
	
}
