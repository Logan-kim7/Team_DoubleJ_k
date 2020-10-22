package com.biz.dripbag.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.dripbag.model.UserVO;

public interface SessionService 
{
	public boolean tempMaster(HttpServletRequest req);
	public boolean sessionRegistration(HttpServletRequest req, UserVO vo);
	public void interceptorLogin(HttpServletResponse res, String message) throws IOException;
	
}
