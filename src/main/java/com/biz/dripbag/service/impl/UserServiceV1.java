package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.model.DAO.UserDAO;
import com.biz.dripbag.service.UserService;


@Service
public class UserServiceV1 implements UserService 
{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<UserVO> sellectAll() 
	{
		
		return userDAO.sellectAll();
	}
	
}
