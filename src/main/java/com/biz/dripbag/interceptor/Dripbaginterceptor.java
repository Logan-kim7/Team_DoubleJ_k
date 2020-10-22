package com.biz.dripbag.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.dripbag.service.SessionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Dripbaginterceptor extends HandlerInterceptorAdapter 
{	
	
	private final SessionService sService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception 
	{
		if(request.getSession().getAttribute("login_registration") == null)
		{
			log.debug("인터셉터 했음");
			sService.interceptorLogin(response, "로그인 해주세요");
			return false;
		}
		return true;
	}

}
