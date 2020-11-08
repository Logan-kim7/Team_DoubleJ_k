package com.biz.dripbag.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.dripbag.service.sub.SessionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
public class interceptor extends HandlerInterceptorAdapter 
{	
	@Qualifier("sessionServiceV1")
	private final SessionService sService;
			
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception 
	{
		sService.Searchclear(request);
		sService.navFlag(request);
		if(request.getSession().getAttribute("member") == null)
		{
			sService.locationJump(response, null, "로그인 해주세요");
			return false;
		}
	
		return true;
	}
	
}

