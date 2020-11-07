package com.biz.dripbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.UserDAO;
import com.biz.dripbag.model.UserVO;
import com.biz.dripbag.service.UserService;
import com.biz.dripbag.service.sub.DateService;

import lombok.RequiredArgsConstructor;


@Service("userServiceV1")
@RequiredArgsConstructor
public class UserServiceV1 implements UserService 
{
	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected DateService dateService;
	
	@Override
	public List<UserVO> selectAll() 
	{
		return userDAO.selectAll();
	}

	@Override
	public UserVO findById(Long id) 
	{
		return userDAO.findById(id);
	}
	
	@Override
	public UserVO findById(String id) 
	{
		return userDAO.findById(id);
	}


	@Override
	public int insert(UserVO vo) 
	{
		vo.setDates(dateService.dateTime()[0]);
		int ret = userDAO.insert(vo);
		return ret;
	}

	@Override
	public int update(UserVO vo) 
	{
		int ret = userDAO.update(vo);
		return ret;
	}

	@Override
	public int delete(Long id) 
	{
		int ret = userDAO.delete(id);
		return ret;
	}
	
	@Override
	public UserVO findById(int flag, UserVO vo, String id)   {
		// TODO Auto-generated method stub
		return null;
	}
}
