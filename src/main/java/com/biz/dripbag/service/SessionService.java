package com.biz.dripbag.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.dripbag.model.UserVO;

public interface SessionService 
{
	public boolean sessionRegistration(HttpServletRequest req, UserVO vo, String master);
	public void locationJump(HttpServletResponse res, String url, String msg) throws IOException;
	public void Searchclear(HttpServletRequest req, String urlPath);
	public void navFlag(HttpServletRequest req);
}
